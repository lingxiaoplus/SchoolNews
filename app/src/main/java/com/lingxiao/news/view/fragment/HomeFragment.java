package com.lingxiao.news.view.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.lingxiao.news.R;
import com.lingxiao.news.adapter.TabEntity;
import com.lingxiao.news.presenter.HomePresenter;
import com.lingxiao.news.retrofit.modle.HomeListModle;
import com.lingxiao.news.utils.LogUtils;
import com.lingxiao.news.view.HomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingxiao on 17-11-30.
 */

public class HomeFragment extends BaseFragment implements HomeView{
    private SlidingTabLayout tabHome;
    private ViewPager vpHome;
    //private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private List<String> mTitleList = new ArrayList<>();
    private HomePresenter presenter;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(),
                R.layout.fragment_home, null);
        tabHome = view.findViewById(R.id.tab_home);
        vpHome = view.findViewById(R.id.vp_home);
        presenter = new HomePresenter(this,mActivity);
        return view;
    }

    @Override
    public void initData() {
        presenter.getListInfo();
    }

    @Override
    public void onGetListInfo(List<HomeListModle.TListBean> tList) {
        LogUtils.i("有数据了");
        for (int i = 0; i < tList.size(); i++) {
            mTitleList.add(tList.get(i).getTname());
            LogUtils.i(tList.get(i).getTname());
        }
        vpHome.setAdapter(new MyPagerAdapter());
        //将list集合转换为string数组
        String[] mTitles = mTitleList.toArray(new String[mTitleList.size()]);
        tabHome.setViewPager(vpHome,mTitles);
    }

    @Override
    public void onGetNewsInfo() {

    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mTitleList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(getActivity());
            textView.setText(mTitleList.get(position));
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            container.addView(textView);
            return textView;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
