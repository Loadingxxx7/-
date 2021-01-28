package com.example.recyclerview.network.kotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/5
 * @email xiaozihuan994@qq.com
 * @description .
 */
interface NewsServiceKotlin {

    @GET("get")
    fun getCount(@Query("channel") channel: String,
                 @Query("start") start: Int,
                 @Query("num") num: Int,
                 @Query("appkey") appkey: String): Call<NewsEntityKotlin>
}