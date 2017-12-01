package com.lingxiao.news.presenter;

import android.os.Bundle;

import com.lingxiao.news.http.listener.LifeCycleListener;
import com.lingxiao.news.view.BaseActivity;
import com.lingxiao.news.view.fragment.BaseFragment;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by lingxiao on 17-12-1.
 * JAVA弱引用，管理View的引用，以及activity的引用，避免强引用导致资源无法释放而造成的内存溢出
 */

public class BasePresenter<V,T> implements LifeCycleListener{
    protected Reference<V> mViewRef;
    protected V mView;
    protected Reference<T> mActivityRef;
    protected T mActivity;

    public BasePresenter(V view, T activity) {
        attachView(view);
        attachActivity(activity);
        setListener(activity);
    }

    private void setListener(T activity) {
        if (getActivity() != null) {
            if (activity instanceof BaseActivity) {
                ((BaseActivity) getActivity()).setOnLifeCycleListener(this);
            } else if (activity instanceof BaseFragment) {
                ((BaseFragment) getActivity()).setOnLifeCycleListener(this);
            }
        }
    }

    private T getActivity() {
        if (mActivityRef == null) {
            return null;
        }
        return mActivityRef.get();
    }


    public V getView() {
        if (mViewRef == null) {
            return null;
        }
        return mViewRef.get();
    }
    /**
     * 是否已经关联
     *
     * @return
     */
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 是否已经关联
     *
     * @return
     */
    public boolean isActivityAttached() {
        return mActivityRef != null && mActivityRef.get() != null;
    }

    private void attachActivity(T activity) {
        mActivityRef = new WeakReference<T>(activity);
        mActivity = mActivityRef.get();
    }

    private void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
        mView = mViewRef.get();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        detachView();
        detachActivity();
    }

    /**
     * 销毁
     */
    private void detachView() {
        if (isViewAttached()) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    /**
     * 销毁
     */
    private void detachActivity() {
        if (isActivityAttached()) {
            mActivityRef.clear();
            mActivityRef = null;
        }
    }
}
