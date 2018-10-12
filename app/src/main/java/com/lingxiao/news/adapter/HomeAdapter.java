package com.lingxiao.news.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingxiao.news.R;
import com.lingxiao.news.retrofit.modle.DetailModel;
import com.lingxiao.news.retrofit.modle.HomeListModle;
import com.lingxiao.news.widget.ColorTextView;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<DetailModel,BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<DetailModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailModel item) {
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setText(R.id.tv_message,item.getDigest());
        ColorTextView colorTextView = helper.getView(R.id.colorTitle);
        colorTextView.setText(item.getSource());
        Glide.with(helper.itemView.getContext())
                .load(item.getImgsrc())
                .into((ImageView) helper.getView(R.id.iv_title));
    }
}
