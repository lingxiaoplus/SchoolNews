package com.lingxiao.news.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
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
        String time = item.getMtime();
        String[] times = time.split(" ");
        if (times.length > 0){
            time = times[0];
        }
        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_message,item.getDigest())
                .setText(R.id.tv_time,time)
                .addOnClickListener(R.id.rl_news)
                .addOnClickListener(R.id.iv_share)
                .addOnClickListener(R.id.iv_comment);
        ColorTextView colorTextView = helper.getView(R.id.colorTitle);
        colorTextView.setText(item.getSource().trim());
        Glide.with(helper.itemView.getContext())
                .load(item.getImgsrc())
                .into((ImageView) helper.getView(R.id.iv_title));
    }
}
