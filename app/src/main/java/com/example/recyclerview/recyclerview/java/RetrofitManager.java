package com.example.recyclerview.recyclerview.java;

import android.util.Log;

import com.example.recyclerview.BuildConfig;
import com.example.recyclerview.main.java.MainActivity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/28
 * @email xiaozihuan994@qq.com
 * @description 懒汉式单例模式
 */
public class RetrofitManager {

    private volatile static RetrofitManager retrofitManager;
    private final Retrofit retrofit;
    private String url;

    public RetrofitManager(String url) {
        this.url = url;
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(message -> {
            if (BuildConfig.DEBUG) {
                Log.e(MainActivity.class.getSimpleName(), message);
            }
        });//创建拦截对象

        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这一句一定要记得写，否则没有数据输出

        //网络请求对象
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(logInterceptor)  //设置打印拦截日志
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)//https://api.66mz8.com/api/
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

//    public static RetrofitManager getInstance() {
//        if (retrofitManager == null) {
//            synchronized (RetrofitManager.class) {
//                if (retrofitManager == null) {
//                    retrofitManager = new RetrofitManager(url);
//                }
//            }
//        }
//        return retrofitManager;
//    }

    public <T> T getService(Class<T> clz) {
        return retrofit.create(clz);
    }

}
