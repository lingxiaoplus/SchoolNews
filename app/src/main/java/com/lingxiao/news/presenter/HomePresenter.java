package com.lingxiao.news.presenter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.lingxiao.news.MainActivity;
import com.lingxiao.news.exception.ApiException;
import com.lingxiao.news.http.HttpResponse;
import com.lingxiao.news.http.HttpRxObservable;
import com.lingxiao.news.http.HttpRxobserver;
import com.lingxiao.news.retrofit.RetrofitUtils;
import com.lingxiao.news.retrofit.api.HomeApi;
import com.lingxiao.news.retrofit.manager.DataManager;
import com.lingxiao.news.retrofit.modle.DetailModel;
import com.lingxiao.news.retrofit.modle.HomeListModle;
import com.lingxiao.news.utils.JsonUtils;
import com.lingxiao.news.utils.LogUtils;
import com.lingxiao.news.view.BaseActivity;
import com.lingxiao.news.view.HomeView;
import com.lingxiao.news.view.fragment.BaseFragment;
import com.lingxiao.news.view.fragment.HomeFragment;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by lingxiao on 17-12-1.
 */

public class HomePresenter extends BasePresenter<HomeView,Fragment> {
    private HomeFragment fragment;
    private HomeView homeView;
    private final String TAG = HomePresenter.class.getSimpleName();
    private int start = 0;
    private int end = 20;
    public HomePresenter(HomeView view, HomeFragment fragment) {
        super(view, fragment);
        this.fragment = fragment;
        this.homeView = view;
    }
    public void getListInfo(final String type, int page){
        start = 20*(page-1);
        end = 20*page;
        String limit = start+"-"+end + ".html";
        RetrofitUtils
                .getInstence()
                .retrofit()
                .create(HomeApi.class)
                .getNewsInfo(type,limit) // 第一步：获取Observable
                .map(new Function<ResponseBody, List<DetailModel>>() {
                    @Override
                    public List<DetailModel> apply(ResponseBody responseBody) throws Exception {
                        String body  = responseBody.string();
                        Log.e(TAG, "获取详情返回的值："+body);
                        List<DetailModel> modelList = JsonUtils.readJsonNewsList(
                                body,type);
                        return modelList;
                    }
                })
                .subscribeOn(Schedulers.io()) //发射事件的线程
                .observeOn(AndroidSchedulers.mainThread()) //接收事件的线程
                .subscribe(new Observer<List<DetailModel>>() {//创建Observer Observable和Observer建立订阅关系
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<DetailModel> modelList) {
                        homeView.onGetListInfo(modelList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i("发射异常"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtils.i("发射完成");
                    }
                });


    }
}
