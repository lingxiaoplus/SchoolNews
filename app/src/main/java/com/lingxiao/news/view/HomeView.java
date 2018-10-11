package com.lingxiao.news.view;

import com.lingxiao.news.retrofit.modle.DetailModel;
import com.lingxiao.news.retrofit.modle.HomeListModle;

import java.util.List;

/**
 * Created by lingxiao on 17-12-1.
 */

public interface HomeView {
    //获取list列表
    void onGetListInfo(List<DetailModel> tList);
    //获取详细的数据
    void onGetNewsInfo();
}
