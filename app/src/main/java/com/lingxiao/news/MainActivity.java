package com.lingxiao.news;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.lingxiao.news.adapter.MainPagerAdapter;
import com.lingxiao.news.view.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tb_title)
    Toolbar tbTitle;
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.bottom_navigation)
    BottomNavigationBar bottomNavigation;
    @BindView(R.id.dl_menu)
    DrawerLayout dlMenu;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mX;
    private int moveX;
    private String[] items = new String[]{"首页","资讯","精选","消息"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initToolBar();
        initBottomBar();
        initViewPager();
    }

    private void initViewPager() {
        List<String> list = new ArrayList<>();
        list.add("首页");
        list.add("资讯");
        list.add("精选");
        list.add("消息");
        MainPagerAdapter mAdapter = new MainPagerAdapter
                (getSupportFragmentManager(),list);
        vpMain.setAdapter(mAdapter);
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigation.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initBottomBar() {
        bottomNavigation
                .setActiveColor(R.color.white)
                .setInActiveColor(R.color.white)
                .setBarBackgroundColor(R.color.white);
        bottomNavigation
                .addItem(new BottomNavigationItem(R.drawable.ic_img_home, items[0])
                        .setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_img_choiceness, items[1])
                        .setActiveColorResource(R.color.colorLightBlue))
                .addItem(new BottomNavigationItem(R.drawable.ic_img_information, items[2])
                        .setActiveColorResource(R.color.colorCyan))
                .addItem(new BottomNavigationItem(R.drawable.ic_img_message, items[2])
                        .setActiveColorResource(R.color.colorTeal))
                .setFirstSelectedPosition(0)
                .initialise();//所有的设置需在调用该方法前完成
        bottomNavigation.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                vpMain.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void initToolBar() {
        tbTitle.setTitle("大新闻");
        setSupportActionBar(tbTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, dlMenu,
                tbTitle, R.string.open, R.string.close) {
        };
        mDrawerToggle.syncState();
        dlMenu.setDrawerListener(mDrawerToggle);
    }


}
