package com.lingxiao.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.lingxiao.news.globe.ContentValue;
import com.lingxiao.news.view.BaseActivity;
import com.lingxiao.news.view.fragment.HomeFragment;
import com.lingxiao.news.widget.RippleAnimation;
import com.lingxiao.skinlibrary.SkinLib;

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

    private Bundle bundle = new Bundle();
    private void initViewPager() {
        MainPagerAdapter mAdapter = new MainPagerAdapter
                (getSupportFragmentManager());
        vpMain.setAdapter(mAdapter);
        vpMain.setOffscreenPageLimit(1);
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

    private String[] skinNames = {"","LightBlue","Cyan","Teal"};
    private int[] skins = {R.color.colorPrimary,
            R.color.colorPrimary_LightBlue,
            R.color.colorPrimary_Cyan,
            R.color.colorPrimary_Teal};
    private void initBottomBar() {
        bottomNavigation
                .setActiveColor(R.color.white)
                .setInActiveColor(R.color.white)
                .setBarBackgroundColor(R.color.white);
        bottomNavigation
                .addItem(new BottomNavigationItem(R.drawable.ic_img_home, items[0])
                        .setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_img_choiceness, items[1])
                        .setActiveColorResource(R.color.colorPrimary_LightBlue))
                .addItem(new BottomNavigationItem(R.drawable.ic_img_information, items[2])
                        .setActiveColorResource(R.color.colorPrimary_Cyan))
                .addItem(new BottomNavigationItem(R.drawable.ic_img_message, items[2])
                        .setActiveColorResource(R.color.colorPrimary_Teal))
                .setFirstSelectedPosition(0)
                .initialise();//所有的设置需在调用该方法前完成
        bottomNavigation.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                RippleAnimation.create(vpMain)
                        .setDuration(1000).start();
                if (position == 0){
                    SkinLib.resetSkin();
                }else {
                    SkinLib.loadSkin(skinNames[position]);
                }
                initTopBarColor(skins[position]);
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
