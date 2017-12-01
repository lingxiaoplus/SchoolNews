package com.lingxiao.news.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lingxiao.news.http.listener.LifeCycleListener;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mListener != null) {
            mListener.onCreate(savedInstanceState);
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
