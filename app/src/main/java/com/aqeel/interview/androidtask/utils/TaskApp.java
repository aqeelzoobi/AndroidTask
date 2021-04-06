package com.aqeel.interview.androidtask.utils;

import android.app.Application;
import android.content.Context;

public class TaskApp extends Application {
    public static Context appInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        appInstance=this.getApplicationContext();

    }

}
