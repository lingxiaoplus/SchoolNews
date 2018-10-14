package com.lingxiao.news.view;

import com.lingxiao.news.retrofit.modle.DetailModel;
import com.lingxiao.news.retrofit.modle.NewsDetailModel;

public interface DetailView {
    void onGetDetail(NewsDetailModel model);
}
