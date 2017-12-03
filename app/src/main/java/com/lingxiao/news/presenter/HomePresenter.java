package com.lingxiao.news.presenter;

import android.app.Activity;

import com.lingxiao.news.MainActivity;
import com.lingxiao.news.exception.ApiException;
import com.lingxiao.news.http.HttpResponse;
import com.lingxiao.news.http.HttpRxObservable;
import com.lingxiao.news.http.HttpRxobserver;
import com.lingxiao.news.retrofit.RetrofitUtils;
import com.lingxiao.news.retrofit.api.HomeApi;
import com.lingxiao.news.retrofit.manager.DataManager;
import com.lingxiao.news.retrofit.modle.HomeListModle;
import com.lingxiao.news.utils.LogUtils;
import com.lingxiao.news.view.BaseActivity;
import com.lingxiao.news.view.HomeView;
import com.lingxiao.news.view.fragment.HomeFragment;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lingxiao on 17-12-1.
 */

public class HomePresenter extends BasePresenter<HomeView,Activity> {
    private Activity activity;
    private HomeView homeView;
    private final String TAG = HomePresenter.class.getSimpleName();
    public HomePresenter(HomeView view, MainActivity activity) {
        super(view, activity);
        this.activity = activity;
        this.homeView = view;
    }
    public void getListInfo(){
        RetrofitUtils
                .getInstence()
                .retrofit()
                .create(HomeApi.class)
                .getListInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeListModle>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeListModle homeListModle) {
                        LogUtils.i("获取到的"+homeListModle.getTList().get(0).getImg());
                        homeView.onGetListInfo(homeListModle.getTList());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
