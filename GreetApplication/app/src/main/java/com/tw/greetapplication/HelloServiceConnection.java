package com.tw.greetapplication;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.tw.helloservice.IHelloService;

public class HelloServiceConnection implements ServiceConnection {
    private static final String TAG = HelloServiceConnection.class.getName();
    private IHelloService helloService;

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d(TAG, "onServiceConnected::componentName:" + componentName + "::IBinder:" + iBinder);
        helloService = IHelloService.Stub.asInterface(iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d(TAG, "onServiceDisconnected::componentName" + componentName);
        helloService = null;
    }

    public String hello() throws RemoteException {
        if (helloService == null) {
            return "Service Bind error";
        }
        return helloService.hello();
    }

    public String ping() throws RemoteException {
        if (helloService == null) {
            return "Service Bind error";
        }
        return helloService.ping();
    }

    public String bye() throws RemoteException {
        if (helloService == null) {
            return "Service Bind error";
        }
        return helloService.bye();
    }
}
