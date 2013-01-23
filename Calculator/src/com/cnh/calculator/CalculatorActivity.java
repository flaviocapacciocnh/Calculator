package com.cnh.calculator;

import com.cnh.calculatorservice.ICalculatorService;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity implements OnClickListener{
	protected static final String TAG = "calculatorActivity";
	CalculatorConnection con;
	ICalculatorService calculatorService;
	TextView resultTv;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		resultTv = (TextView) findViewById(R.id.resulTextView3);


		Intent intent = new Intent("com.cnh.calculatorservice");
		CalculatorConnection con = new CalculatorConnection();
		bindService(intent, con, Service.BIND_AUTO_CREATE);

		Button addButton = (Button) findViewById(R.id.addButton);
		Button subtractButton = (Button) findViewById(R.id.subtractButton);
		Button multiplyButton = (Button) findViewById(R.id.multiplyButton);
		Button divideButton = (Button) findViewById(R.id.divideButton);
		Button cleanButton = (Button) findViewById(R.id.cleanButton);

		addButton.setOnClickListener(this);
		subtractButton.setOnClickListener(this);
		multiplyButton.setOnClickListener(this);
		divideButton.setOnClickListener(this);
		cleanButton.setOnClickListener(this);
	}

	public class CalculatorConnection implements ServiceConnection{
		public void onServiceConnected(ComponentName arg0, IBinder service) {
			calculatorService = ICalculatorService.Stub.asInterface(service);
		}

		public void onServiceDisconnected(ComponentName arg0) {
			calculatorService = null;
		}
	}

	public void onClick(View button) {
		EditText et1 = null;
		EditText et2 = null;
		double res = 0;
		try{
			et1 = (EditText) findViewById(R.id.operando1EditText);
			et2 = (EditText) findViewById(R.id.operando2EditText);
			double op1 = Double.parseDouble(et1.getText().toString());
			double op2 = Double.parseDouble(et2.getText().toString());
			
			switch (button.getId()) {
			case R.id.addButton:
				res = calculatorService.sum(op1, op2);
				break;
				
			case R.id.subtractButton:
				res = calculatorService.subtract(op1, op2);
				break;
				
			case R.id.multiplyButton:
				res = calculatorService.multiply(op1, op2);
				break;
				
			case R.id.divideButton:
				res = calculatorService.divide(op1, op2);
				break;
				
			case R.id.cleanButton:
				et1.setText("");
				et2.setText("");
				break;
				
			default:
				break;
			}
			resultTv.setText("Risultato: " + res);
		} catch (NumberFormatException e){
			et1.setText("");
			et2.setText("");
			Toast.makeText(getApplicationContext(), R.string.invalid_input_value, Toast.LENGTH_SHORT).show();
		} catch (RemoteException e) {
			Log.d(TAG, "Errore nel binding del servizio", e);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calculator, menu);
		return true;
	}
	
}
