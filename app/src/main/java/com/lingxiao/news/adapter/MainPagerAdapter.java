package com.lingxiao.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lingxiao.news.view.fragment.HomeFragment;

import java.util.List;

/**
 * Created by lingxiao on 17-11-30.
 */

public class MainPagerAdapter extends FragmentPagerAdapter{
    List list;
    public MainPagerAdapter(FragmentManager fm, List list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
