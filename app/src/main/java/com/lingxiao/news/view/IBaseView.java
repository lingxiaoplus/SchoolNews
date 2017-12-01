package com.lingxiao.news.view;

/**
 * Created by lingxiao on 17-11-29.
 */

public interface IBaseView {
    //显示loading
    void showLoading();

    //关闭loading
    void closeLoading();

    //显示吐司
    void showToast(String msg);
}
