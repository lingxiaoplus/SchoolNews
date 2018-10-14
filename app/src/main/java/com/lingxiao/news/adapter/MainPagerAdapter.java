package com.lingxiao.news.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lingxiao.news.view.fragment.HomeFragment;

import java.util.List;

/**
 * Created by lingxiao on 17-11-30.
 */

public class MainPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> mList;
    public MainPagerAdapter(FragmentManager fm, List list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

}
