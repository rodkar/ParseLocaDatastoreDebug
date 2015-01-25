package com.cloudyun.parselocaldatastoredebug;

import android.app.Application;
import android.content.Context;

/**
 * Created by 2013_13_mbp on 23/1/15.
 */
public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getmContext(){
        return mContext;
    }
}