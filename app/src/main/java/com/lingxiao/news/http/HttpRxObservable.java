package com.lingxiao.news.http;

import android.app.Activity;

import com.lingxiao.news.exception.HttpResultFunction;
import com.lingxiao.news.exception.ServerResultFunction;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lingxiao on 17-11-29.
 * 获取被监听者
 * 备注:网络请求Observable构建
 * data:网络请求参数
 * <h1>补充说明</h1>
 * 传入LifecycleProvider自动管理生命周期,避免内存溢出
 * 备注:需要继承RxActivity.../RxFragment...
 */

public class HttpRxObservable {
    public static Observable getObservable(Observable<HttpResponse> apiObservable, LifecycleProvider lifecycle) {
        //showLog(request);
        Observable observable;
        //随生命周期自动管理.eg:onCreate(start)->onStop(end)
        observable =apiObservable
                .map(new ServerResultFunction())
                .compose(lifecycle.bindToLifecycle())//需要在这个位置添加
                .onErrorResumeNext(new HttpResultFunction<>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
}
