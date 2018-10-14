package com.lingxiao.news.retrofit.manager;

import com.lingxiao.news.http.HttpResponse;
import com.lingxiao.news.retrofit.RetrofitUtils;
import com.lingxiao.news.retrofit.api.HomeApi;
import com.lingxiao.news.retrofit.modle.HomeListModle;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by lingxiao on 17-12-1.
 */

public class DataManager {
    private HomeApi homeApi;
    public DataManager(){
        this.homeApi = RetrofitUtils
                        .getInstence()
                        .getInterface(HomeApi.class);
    }
    public Observable<HomeListModle> getListInfo(String type, String limit){
        return homeApi.getNewsInfo(type,limit);
    }
}
