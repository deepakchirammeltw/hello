package com.tw.helloservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class HelloService extends Service {
    private final IHelloService.Stub mBinder = new IHelloService.Stub() {
        @Override
        public String hello() {
            return "Hello and Welcome to TW";
        }

        @Override
        public String ping() {
            return "pong";
        }

        @Override
        public String bye() {
            return "Thank You. See you again";
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
