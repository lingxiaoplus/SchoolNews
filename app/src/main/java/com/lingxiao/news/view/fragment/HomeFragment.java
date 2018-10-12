package com.lingxiao.news.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lingxiao.news.R;
import com.lingxiao.news.adapter.HomeAdapter;
import com.lingxiao.news.presenter.HomePresenter;
import com.lingxiao.news.retrofit.modle.DetailModel;
import com.lingxiao.news.utils.LogUtils;
import com.lingxiao.news.view.HomeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lingxiao on 17-11-30.
 */

public class HomeFragment extends BaseFragment implements HomeView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private HomePresenter presenter;
    private List<DetailModel> mDetailList = new ArrayList<>();
    private HomeAdapter mAdapter;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initWidget(View view) {
        super.initWidget(view);
        presenter = new HomePresenter(this, mActivity);
    }

    @Override
    public void initData() {
        presenter.getListInfo();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        mAdapter = new HomeAdapter(R.layout.news_item,mDetailList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onGetListInfo(List<DetailModel> tList) {
        LogUtils.i("有数据了");
        mAdapter.addData(tList);
    }

    @Override
    public void onGetNewsInfo() {

    }
}
