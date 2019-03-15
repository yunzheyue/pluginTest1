package com.example.base;

import android.app.Application;
import android.util.Log;

public class MyBaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "MyBaseApplication====onCreate==");
    }
}
