package com.lingxiao.news.adapter;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by lingxiao on 17-12-1.
 */

public class TabEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;
    public TabEntity(String title/*, int selectedIcon, int unSelectedIcon*/){
        this.title = title;
        //this.selectedIcon = selectedIcon;
        //this.unSelectedIcon = unSelectedIcon;
    }
    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
