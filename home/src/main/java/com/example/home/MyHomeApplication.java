package com.example.home;

import android.app.Application;
import android.util.Log;

public class MyHomeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "MyHomeApplication====onCreate==");
    }
}
