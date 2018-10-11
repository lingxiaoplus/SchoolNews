package com.lingxiao.news.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingxiao.news.R;
import com.lingxiao.news.retrofit.modle.HomeListModle;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<HomeListModle,BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<HomeListModle> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeListModle item) {

    }
}
