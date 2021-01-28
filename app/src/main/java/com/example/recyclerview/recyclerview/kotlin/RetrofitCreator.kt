package com.example.recyclerview.recyclerview.kotlin

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/5
 * @email xiaozihuan994@qq.com
 * @description 静态内部类单例模式
 */

class RetrofitCreator private constructor() {

    private var logInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
        Log.e(RetrofitCreator::class.simpleName,it)
    }).setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor(logInterceptor)
            .build()

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.jisuapi.com/news/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    fun <T> create(clz: Class<T>): T {
        return retrofit.create(clz)
    }

    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = RetrofitCreator()
    }

}