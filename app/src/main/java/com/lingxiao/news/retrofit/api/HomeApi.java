package com.lingxiao.news.retrofit.api;

import com.lingxiao.news.http.HttpResponse;
import com.lingxiao.news.retrofit.modle.HomeListModle;

import java.util.Observer;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lingxiao on 17-12-1.
 */

public interface HomeApi {
    @GET("/nc/topicset/android/subscribe/manage/listspecial.html")
    Observable<HttpResponse> listInfo();
}
