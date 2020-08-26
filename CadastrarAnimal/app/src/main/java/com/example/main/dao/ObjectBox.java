package com.example.main.dao;

import android.app.Application;

import com.example.MyObjectBox;

import io.objectbox.BoxStore;

public class ObjectBox extends Application {

    private static ObjectBox obj;
    private static BoxStore mBoxStore;

    @Override

    public void onCreate() {

        super.onCreate();

        obj = this;
        mBoxStore = MyObjectBox.builder().androidContext(ObjectBox.this).build();

    }

    public static ObjectBox getApp(){
        return obj;
    }

    public static BoxStore get() {

        return mBoxStore;

    }
}
