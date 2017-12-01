package com.lingxiao.news.http.listener;

import android.os.Bundle;

/**
 * Created by lingxiao on 17-12-1.
 * 监听生命周期
 */

public interface LifeCycleListener {
    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onRestart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}
