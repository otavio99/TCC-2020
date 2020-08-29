package com.example.main;

import android.content.Context;

import com.example.MyObjectBox;

import io.objectbox.BoxStore;

public class ObjectBox {

    private static BoxStore boxStore;

    static void init(Context context) {
        boxStore = MyObjectBox.builder()
                .androidContext(context.getApplicationContext())
                .build();
    }

    public static BoxStore get() {
        return boxStore;
    }
}
