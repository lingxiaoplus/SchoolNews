package com.lingxiao.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.github.zackratos.ultimatebar.UltimateBar;
import com.lingxiao.news.presenter.DetailPresenter;
import com.lingxiao.news.retrofit.modle.NewsDetailModel;
import com.lingxiao.news.utils.LogUtils;
import com.lingxiao.news.utils.WebUtils;
import com.lingxiao.news.view.BaseActivity;
import com.lingxiao.news.view.DetailView;
import com.lingxiao.news.widget.SpecialWebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity implements DetailView {

    @BindView(R.id.toolbar)
    Toolbar toolbarTitle;
    @BindView(R.id.pb_web)
    ProgressBar pbWeb;
    @BindView(R.id.webview)
    SpecialWebView webview;
    @BindView(R.id.iv_about)
    ImageView imageTitle;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.scrollview)
    NestedScrollView scrollView;

    private DetailPresenter mPresenter;
    private String mHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        initWebView();
        initView();
        webview.getSettings().setUserAgentString("NewsApp/44.0 Android/6.0.1 (nubia/NX549J)");
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                pbWeb.setVisibility(View.INVISIBLE);

            }
        });

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                pbWeb.setProgress(newProgress);
            }
        });
        webview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
                        //表示按返回键时的操作
                        webview.goBack();   //后退
                        //webview.goForward();//前进
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
        webview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (mAppBarLayout.getWidth() <= 0){
                    ((WebView)view).requestDisallowInterceptTouchEvent(true);
                }
                LogUtils.d("appbar的高度："+mAppBarLayout.getWidth());
                return false;
            }
        });
    }

    private void initView() {
        UltimateBar.newTransparentBuilder()
                .statusColor(getResources().getColor(R.color.transparent))        // 状态栏颜色
                .statusAlpha(100)               // 状态栏透明度
                .applyNav(false)                // 是否应用到导航栏
                .build(this)
                .apply();
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String imageUrl = intent.getStringExtra("image");
        String docid = intent.getStringExtra("docid");
        toolbarTitle.setTitle(title);
        setSupportActionBar(toolbarTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mPresenter = new DetailPresenter(this, this);
        mPresenter.getListInfo(docid);
        Glide.with(this).load(imageUrl).into(imageTitle);
    }

    private void initWebView() {
        //声明WebSettings子类
        WebSettings webSettings = webview.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);//采用 ajax 框架请求后台数据
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
        // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可
        //支持插件
        //webSettings.setPluginsEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        //其他细节操作
        //webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onGetDetail(NewsDetailModel model) {
        // 加载新闻数据，如果图片跟标题图相同则不加载
        String htmlBody = WebUtils.newsInsertPic(model);
        mHtml = WebUtils.buildHtmlForIt(htmlBody, false);
        //mImageUrls = WebUtils.getImageUrlsFromHtml(html);
        webview.loadDataWithBaseURL(WebUtils.BASE_URL, mHtml, WebUtils.MIME_TYPE,
                WebUtils.ENCODING, WebUtils.FAIL_URL);

    }
}
