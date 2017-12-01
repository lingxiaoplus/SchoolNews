package com.lingxiao.news.exception;

import com.google.gson.Gson;
import com.lingxiao.news.http.HttpResponse;
import com.lingxiao.news.utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by lingxiao on 17-11-29.
 */

public class ServerResultFunction<T> implements Function<HttpResponse,Object>{

    @Override
    public Object apply(HttpResponse httpResponse) throws Exception {
        //打印服务器回传结果
        LogUtils.e(httpResponse.toString());
        if (!httpResponse.isSuccess()) {
            throw new ServerException(httpResponse.getCode(), httpResponse.getMsg());
        }
        return new Gson().toJson(httpResponse.getResult());
    }
}
