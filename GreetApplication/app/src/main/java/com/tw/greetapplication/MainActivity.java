package com.tw.greetapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private static final String HELLO_SERVICE_PACKAGE_NAME = "com.tw.helloservice";
    private static final String HELLO_SERVICE_NAME = "com.tw.helloservice.HelloService";
    private HelloServiceConnection helloServiceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate::savedInstanceState:" + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectService();
        findViewById(R.id.hello_button).setOnClickListener(this::onHelloClick);
        findViewById(R.id.ping_button).setOnClickListener(this::onPingClick);
        findViewById(R.id.bye_button).setOnClickListener(this::onByeClick);
    }

    private void connectService() {
        Log.d(TAG, "connectService");
        helloServiceConnection = new HelloServiceConnection();
        Intent helloServiceIntent = new Intent();
        helloServiceIntent.setComponent(new ComponentName(HELLO_SERVICE_PACKAGE_NAME, HELLO_SERVICE_NAME));
        bindService(helloServiceIntent, helloServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private void onHelloClick(View view) {
        try {
            Toast.makeText(MainActivity.this, helloServiceConnection.hello(), Toast.LENGTH_LONG).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void onPingClick(View view) {
        try {
            Toast.makeText(MainActivity.this, helloServiceConnection.ping(), Toast.LENGTH_LONG).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void onByeClick(View view) {
        try {
            Toast.makeText(MainActivity.this, helloServiceConnection.bye(), Toast.LENGTH_LONG).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}