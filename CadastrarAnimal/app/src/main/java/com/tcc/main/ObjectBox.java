package com.tcc.main;

import android.content.Context;

import com.tcc.MyObjectBox;

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
