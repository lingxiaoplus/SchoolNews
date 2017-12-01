package com.lingxiao.news.http;

import io.reactivex.disposables.Disposable;

/**
 * Created by lingxiao on 17-11-30.
 */

public interface RxActionManager<T> {
    /**
     *添加
     */
    void add(T tag, Disposable disposable);
    /**
     *移除
     */
    void remove(T tag);
    /**
     *取消
     */
    void cancel(T tag);
}
