package com.lingxiao.news.retrofit.api;

import com.lingxiao.news.http.HttpResponse;
import com.lingxiao.news.retrofit.modle.DetailModel;
import com.lingxiao.news.retrofit.modle.HomeListModle;

import java.util.Observer;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lingxiao on 17-12-1.
 */

public interface HomeApi {
    @GET("/nc/article/list/{type}/{limit}")
    Observable<HomeListModle> getNewsInfo(@Path("type") String type, @Path("limit") String limit);

    @GET("/nc/article/{id}/full.html")
    Observable<ResponseBody> getNewsDetail(@Path("id") String id);
}
