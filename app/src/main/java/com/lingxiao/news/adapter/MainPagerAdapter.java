package com.lingxiao.news.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lingxiao.news.globe.ContentValue;
import com.lingxiao.news.view.fragment.HomeFragment;

import java.util.List;

/**
 * Created by lingxiao on 17-11-30.
 */

public class MainPagerAdapter extends FragmentPagerAdapter{
    //private List<Fragment> mList;
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        //this.mList = list;
    }
    private Bundle bundle = new Bundle();
    @Override
    public Fragment getItem(int position) {
        HomeFragment homeFragment = new HomeFragment();
        if (position == 0){
            bundle.putString("type",ContentValue.TRUTH_URL);
        }else {
            bundle.putString("type",ContentValue.HEADLINE_URL);
        }
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

}
