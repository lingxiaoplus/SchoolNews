package com.lingxiao.news.retrofit;

import com.lingxiao.news.globe.ContentValue;
import com.lingxiao.news.utils.LogUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lingxiao on 17-11-29.
 */

public class RetrofitUtils {
    public static final int CONNECT_TIME_OUT = 30;//连接超时时长x秒
    public static final int READ_TIME_OUT = 30;//读数据超时时长x秒
    public static final int WRITE_TIME_OUT = 30;//写数据接超时时长x秒
    private static RetrofitUtils mInstance = null;

    private RetrofitUtils(){

    }

    public static RetrofitUtils getInstence(){
        if (mInstance == null){
            synchronized (RetrofitUtils.class){
                if (mInstance == null){
                    mInstance = new RetrofitUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     *设置okhttp
     */
    private static OkHttpClient okHttpClient(){
        //开启log
        HttpLoggingInterceptor logging = new
                HttpLoggingInterceptor(new HttpLoggingInterceptor
                .Logger() {
            @Override
            public void log(String message) {
                LogUtils.e("okhttp"+message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
        return client;
    }
    /**
     *获取retrofit
     */
    public Retrofit retrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient())
                .baseUrl(ContentValue.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
