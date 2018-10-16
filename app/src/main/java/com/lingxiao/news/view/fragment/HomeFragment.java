package com.lingxiao.news.view.fragment;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lingxiao.news.R;
import com.lingxiao.news.WebActivity;
import com.lingxiao.news.adapter.HomeAdapter;
import com.lingxiao.news.globe.ContentValue;
import com.lingxiao.news.presenter.HomePresenter;
import com.lingxiao.news.retrofit.modle.DetailModel;
import com.lingxiao.news.utils.LogUtils;
import com.lingxiao.news.view.HomeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

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
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private List<DetailModel> mDetailList = new ArrayList<>();
    private HomeAdapter mAdapter;
    private int mPage = 1;
    private static final String TAG = HomeFragment.class.getSimpleName();
    private HomePresenter presenter = new HomePresenter(this, this);
    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initWidget(View view) {
        super.initWidget(view);

    }

    @Override
    public void initData(Bundle bundle) {
        String type = bundle.getString("type");
        Log.i(TAG, "获取到的bundle数据："+type);
        presenter.getListInfo(type,1);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        mAdapter = new HomeAdapter(R.layout.news_item, mDetailList);
        mAdapter.openLoadAnimation();
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.rl_news:
                        Intent intent = new Intent(getActivity(), WebActivity.class);
                        intent.putExtra("docid",mDetailList.get(position).getDocid());
                        intent.putExtra("title",mDetailList.get(position).getTitle());
                        intent.putExtra("image",mDetailList.get(position).getImgsrc());
                        LogUtils.d("新闻详情："+mDetailList.get(position).getUrl());
                        startActivity(intent);
                        break;
                }
            }
        });


        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                presenter.getListInfo(ContentValue.TRUTH_URL,1);
                mDetailList.clear();
                //refreshLayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败

            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //refreshLayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                mPage++;
                presenter.getListInfo(ContentValue.TRUTH_URL,mPage);
            }
        });

    }

    @Override
    public void onGetListInfo(List<DetailModel> tList) {
        LogUtils.i("有数据了");
        if (tList.size() < 20){
            refreshLayout.finishLoadMore();
        }
        mDetailList.addAll(tList);
        mAdapter.notifyDataSetChanged();
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
    }

    @Override
    public void onGetNewsInfo() {

    }

}
