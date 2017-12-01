package com.lingxiao.news.http;

import android.text.TextUtils;

import com.lingxiao.news.exception.ApiException;
import com.lingxiao.news.exception.ExceptionEngine;
import com.lingxiao.news.http.listener.HttpRequestListener;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by lingxiao on 17-11-29.
 */

public abstract class HttpRxobserver<T> implements Observer<T>,HttpRequestListener {

    private String mTag;//请求标识

    public HttpRxobserver() {
    }

    public HttpRxobserver(String tag) {
        this.mTag = tag;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (!TextUtils.isEmpty(mTag)){
            RxActionManagerImpl.getInstance().add(mTag,d);
        }
        onStart(d);
    }

    @Override
    public void onNext(T t) {
        if (!TextUtils.isEmpty(mTag)){
            RxActionManagerImpl.getInstance().remove(mTag);
        }
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        RxActionManagerImpl.getInstance().remove(mTag);
        if (e instanceof ApiException){
            onError(e);
        }else {
            onError(new ApiException(e, ExceptionEngine.UN_KNOWN_ERROR));
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void cancel() {
        if (!TextUtils.isEmpty(mTag)){
            RxActionManagerImpl.getInstance().cancel(mTag);
        }
    }

    /**
     * 错误/异常回调
     */
    protected abstract void onError(ApiException e);

    /**
     * 成功回调
     */
    protected abstract void onSuccess(T response);
    /**
     *开始请求
     */
    protected abstract void onStart(Disposable d);

    /**
     * 是否已经处理
     */
    public boolean isDisposed() {
        if (TextUtils.isEmpty(mTag)) {
            return true;
        }
        return RxActionManagerImpl.getInstance().isDisposed(mTag);
    }
}
