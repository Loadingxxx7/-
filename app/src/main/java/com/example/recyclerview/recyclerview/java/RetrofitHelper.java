package com.example.recyclerview.recyclerview.java;

import android.telecom.StatusHints;
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
 * @data 2020/12/29
 * @email xiaozihuan994@qq.com
 * @description 静态内部类单例模式
 */
public class RetrofitHelper {
    private final Retrofit retrofit;

    private static final class SingletonHandler {
        static final RetrofitHelper INSTANCE = new RetrofitHelper();
    }

    public static RetrofitHelper getInstance() {
        return SingletonHandler.INSTANCE;
    }

    private RetrofitHelper() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(message -> {
            if (BuildConfig.DEBUG) {
                Log.e(RetrofitHelper.class.getSimpleName(), message);
            }
        });//创建拦截对象

        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这一句一定要记得写，否则没有数据输出

        //网络请求对象
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(logInterceptor)  //设置打印拦截日志
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.mxnzp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public <T> T getService(Class<T> clz) {
        return retrofit.create(clz);
    }

}
