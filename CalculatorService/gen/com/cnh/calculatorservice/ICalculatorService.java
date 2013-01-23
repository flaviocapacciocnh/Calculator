/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\users\\F58004A\\newWorkspaceAndroid\\CalculatorService\\src\\com\\cnh\\calculatorservice\\ICalculatorService.aidl
 */
package com.cnh.calculatorservice;
public interface ICalculatorService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.cnh.calculatorservice.ICalculatorService
{
private static final java.lang.String DESCRIPTOR = "com.cnh.calculatorservice.ICalculatorService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.cnh.calculatorservice.ICalculatorService interface,
 * generating a proxy if needed.
 */
public static com.cnh.calculatorservice.ICalculatorService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.cnh.calculatorservice.ICalculatorService))) {
return ((com.cnh.calculatorservice.ICalculatorService)iin);
}
return new com.cnh.calculatorservice.ICalculatorService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_sum:
{
data.enforceInterface(DESCRIPTOR);
double _arg0;
_arg0 = data.readDouble();
double _arg1;
_arg1 = data.readDouble();
double _result = this.sum(_arg0, _arg1);
reply.writeNoException();
reply.writeDouble(_result);
return true;
}
case TRANSACTION_subtract:
{
data.enforceInterface(DESCRIPTOR);
double _arg0;
_arg0 = data.readDouble();
double _arg1;
_arg1 = data.readDouble();
double _result = this.subtract(_arg0, _arg1);
reply.writeNoException();
reply.writeDouble(_result);
return true;
}
case TRANSACTION_multiply:
{
data.enforceInterface(DESCRIPTOR);
double _arg0;
_arg0 = data.readDouble();
double _arg1;
_arg1 = data.readDouble();
double _result = this.multiply(_arg0, _arg1);
reply.writeNoException();
reply.writeDouble(_result);
return true;
}
case TRANSACTION_divide:
{
data.enforceInterface(DESCRIPTOR);
double _arg0;
_arg0 = data.readDouble();
double _arg1;
_arg1 = data.readDouble();
double _result = this.divide(_arg0, _arg1);
reply.writeNoException();
reply.writeDouble(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.cnh.calculatorservice.ICalculatorService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public double sum(double op1, double op2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
double _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeDouble(op1);
_data.writeDouble(op2);
mRemote.transact(Stub.TRANSACTION_sum, _data, _reply, 0);
_reply.readException();
_result = _reply.readDouble();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public double subtract(double op1, double op2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
double _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeDouble(op1);
_data.writeDouble(op2);
mRemote.transact(Stub.TRANSACTION_subtract, _data, _reply, 0);
_reply.readException();
_result = _reply.readDouble();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public double multiply(double op1, double op2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
double _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeDouble(op1);
_data.writeDouble(op2);
mRemote.transact(Stub.TRANSACTION_multiply, _data, _reply, 0);
_reply.readException();
_result = _reply.readDouble();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public double divide(double op1, double op2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
double _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeDouble(op1);
_data.writeDouble(op2);
mRemote.transact(Stub.TRANSACTION_divide, _data, _reply, 0);
_reply.readException();
_result = _reply.readDouble();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_sum = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_subtract = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_multiply = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_divide = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public double sum(double op1, double op2) throws android.os.RemoteException;
public double subtract(double op1, double op2) throws android.os.RemoteException;
public double multiply(double op1, double op2) throws android.os.RemoteException;
public double divide(double op1, double op2) throws android.os.RemoteException;
}
