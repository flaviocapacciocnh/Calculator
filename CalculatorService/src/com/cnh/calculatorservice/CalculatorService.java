package com.cnh.calculatorservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class CalculatorService extends Service{

	public IBinder onBind(Intent arg0) {
		return new ICalculatorService.Stub() {

			public double sum(double op1, double op2) throws RemoteException {
				return op1 + op2;
			}

			public double subtract(double op1, double op2)
					throws RemoteException {
				return op1-op2;
			}

			public double multiply(double op1, double op2)
					throws RemoteException {
				return op1*op2;
			}

			public double divide(double op1, double op2)
					throws RemoteException {
				return op1/op2;
			}
		};
	}
}
