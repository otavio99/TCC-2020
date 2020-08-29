package com.example.main;

import android.app.Application;

public class App extends Application {

    public static final String TAG = "Relations";

    @Override
    public void onCreate() {
        super.onCreate();
        ObjectBox.init(this);
    }

}
