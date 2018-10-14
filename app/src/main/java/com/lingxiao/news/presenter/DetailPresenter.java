package com.lingxiao.news.presenter;

import com.lingxiao.news.WebActivity;
import com.lingxiao.news.retrofit.RetrofitUtils;
import com.lingxiao.news.retrofit.api.HomeApi;
import com.lingxiao.news.retrofit.modle.HomeListModle;
import com.lingxiao.news.retrofit.modle.NewsDetailModel;
import com.lingxiao.news.utils.JsonUtils;
import com.lingxiao.news.utils.LogUtils;
import com.lingxiao.news.view.DetailView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class DetailPresenter extends BasePresenter<DetailView,WebActivity>{
    private DetailView mDetailView;
    public DetailPresenter(DetailView view, WebActivity activity) {
        super(view, activity);
        this.mDetailView = view;
    }
    public void getListInfo(final String id){

        RetrofitUtils
                .getInstence()
                .retrofit()
                .create(HomeApi.class)
                .getNewsDetail(id) // 第一步：获取Observable
                .map(new Function<ResponseBody, NewsDetailModel>() {
                    @Override
                    public NewsDetailModel apply(ResponseBody responseBody) throws Exception {
                        NewsDetailModel model = JsonUtils.readJsonNewsContent(
                                responseBody.string(),id);
                        return model;
                    }
                })
                .subscribeOn(Schedulers.io()) //发射事件的线程
                .observeOn(AndroidSchedulers.mainThread()) //接收事件的线程
                .subscribe(new Observer<NewsDetailModel>() {//创建Observer Observable和Observer建立订阅关系
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsDetailModel model) {
                        mDetailView.onGetDetail(model);
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
