package com.lingxiao.news.exception;

import com.lingxiao.news.utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by lingxiao on 17-11-29.
 */

public class HttpResultFunction<T> implements Function<Throwable,Observable<T>> {
    @Override
    public Observable<T> apply(Throwable throwable) throws Exception {
        //打印具体错误
        LogUtils.e("HttpResultFunction"+throwable);
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
