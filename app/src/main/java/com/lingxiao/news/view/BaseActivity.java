package com.lingxiao.news.view;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.github.zackratos.ultimatebar.UltimateBar;
import com.lingxiao.news.R;
import com.lingxiao.news.http.listener.LifeCycleListener;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


public class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTopBarColor(R.color.colorPrimary);
        if (mListener != null) {
            mListener.onCreate(savedInstanceState);
        }
    }

    public void initTopBarColor(int color){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            UltimateBar.newColorBuilder()
                    .statusColor(ContextCompat.getColor(this, color))   // 状态栏颜色
                    .applyNav(true)             // 是否应用到导航栏
                    .navColor(ContextCompat.getColor(this, color))         // 导航栏颜色
                    .navDepth(0)            // 导航栏颜色深度
                    .build(this)
                    .apply();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (mListener != null) {
            mListener.onStart();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mListener != null) {
            mListener.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mListener != null) {
            mListener.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mListener != null) {
            mListener.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mListener != null) {
            mListener.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mListener != null) {
            mListener.onDestroy();
        }
    }
    /**
     * 回调函数
     */
    public LifeCycleListener mListener;

    public void setOnLifeCycleListener(LifeCycleListener listener) {
        mListener = listener;
    }
}
