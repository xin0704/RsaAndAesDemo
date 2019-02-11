package com.xin.rsaandaesdemo.Base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by admin on 2019/1/30.
 */

public class MyApplication extends Application {

    private static MyApplication application;

    public static SharedPreferences sp;

    public static SharedPreferences.Editor editor;

    public static MyApplication getApplication(){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        sp = getSharedPreferences("RSA_AES_DEMO_SP", Context.MODE_PRIVATE);
        editor = sp.edit();
    }
}
