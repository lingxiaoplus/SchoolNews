package com.lingxiao.news.presenter;

import android.app.Activity;

import com.lingxiao.news.exception.ApiException;
import com.lingxiao.news.http.HttpRxObservable;
import com.lingxiao.news.http.HttpRxobserver;
import com.lingxiao.news.retrofit.RetrofitUtils;
import com.lingxiao.news.retrofit.api.HomeApi;
import com.lingxiao.news.view.HomeView;
import com.lingxiao.news.view.fragment.HomeFragment;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.disposables.Disposable;

/**
 * Created by lingxiao on 17-12-1.
 */

public class HomePresenter extends BasePresenter<HomeView,HomeFragment> {
    private Activity activity;
    private final String TAG = HomePresenter.class.getSimpleName();
    public HomePresenter(HomeView view, HomeFragment fragment) {
        super(view, fragment);
        this.activity = fragment.getActivity();
    }
    public void getListInfo(){
        HttpRxobserver httpRxobserver = new HttpRxobserver() {
            @Override
            protected void onError(ApiException e) {

            }

            @Override
            protected void onSuccess(Object response) {

            }

            @Override
            protected void onStart(Disposable d) {

            }
        };
        HttpRxObservable.getObservable(RetrofitUtils
                .getInstence().retrofit().create(HomeApi.class).listInfo(),
                (LifecycleProvider) activity);
    }
}
