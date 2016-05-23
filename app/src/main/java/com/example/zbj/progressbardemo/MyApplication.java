package com.example.zbj.progressbardemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by zbj on 16/5/23.
 */
public class MyApplication extends Application{

    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }

    public static Context getContext() {
        return MyApplication.getApplication();
        
    }

    private static Context getApplication() {
        return application;
    }
}
