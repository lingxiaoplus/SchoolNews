package com.lingxiao.news.view.fragment;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.lingxiao.news.R;
import com.lingxiao.news.adapter.MainPagerAdapter;
import com.lingxiao.news.adapter.TabEntity;
import com.lingxiao.news.presenter.HomePresenter;
import com.lingxiao.news.view.HomeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lingxiao on 17-11-30.
 */

public class HomeFragment extends BaseFragment implements HomeView{
    private SlidingTabLayout tabHome;
    private ViewPager vpHome;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String[] mTitles = {"首页", "消息", "联系人", "更多","首页", "消息", "联系人", "更多"};

    @Override
    public View initView() {
        View view = View.inflate(getActivity(),
                R.layout.fragment_home, null);
        tabHome = view.findViewById(R.id.tab_home);
        vpHome = view.findViewById(R.id.vp_home);
        vpHome.setAdapter(new MyPagerAdapter());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i]));
        }
        tabHome.setViewPager(vpHome,mTitles);
        HomePresenter presenter = new HomePresenter(view,this);
        return view;
    }

    @Override
    public void initData() {

    }

    @Override
    public void onGetListInfo() {

    }

    @Override
    public void onGetNewsInfo() {

    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(getActivity());
            textView.setText(mTitles[position]);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            container.addView(textView);
            return textView;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
