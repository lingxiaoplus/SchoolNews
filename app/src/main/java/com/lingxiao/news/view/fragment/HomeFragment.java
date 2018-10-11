package com.lingxiao.news.view.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.lingxiao.news.R;
import com.lingxiao.news.adapter.TabEntity;
import com.lingxiao.news.presenter.HomePresenter;
import com.lingxiao.news.retrofit.modle.DetailModel;
import com.lingxiao.news.retrofit.modle.HomeListModle;
import com.lingxiao.news.utils.LogUtils;
import com.lingxiao.news.view.HomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingxiao on 17-11-30.
 */

public class HomeFragment extends BaseFragment implements HomeView{
    private HomePresenter presenter;
    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initWidget(View view) {
        super.initWidget(view);
        presenter = new HomePresenter(this,mActivity);
    }

    @Override
    public void initData() {
        presenter.getListInfo();
    }

    @Override
    public void onGetListInfo(List<DetailModel> tList) {
        LogUtils.i("有数据了");
    }

    @Override
    public void onGetNewsInfo() {

    }

}
