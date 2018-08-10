package com.tronxincloud.bmobtest.common;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

/**
 * Created by Jzhson Davis on 8/5/2018.
 */

public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        // android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        context = this.getApplicationContext();
    }
}
