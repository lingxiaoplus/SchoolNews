package com.lingxiao.news.globe;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by lingxiao on 17-11-30.
 */

public class NewsApplication extends Application {
    private static Context mContext;
    private static Handler mHandler;
    private static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mHandler = new Handler();
        mainThreadId = android.os.Process.myPid();
    }

    public static Context getContext() {
        return mContext;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }
}
