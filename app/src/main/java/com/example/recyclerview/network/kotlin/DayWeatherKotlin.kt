package com.example.recyclerview.network.kotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/6
 * @email xiaozihuan994@qq.com
 * @description .
 */
interface DayWeatherKotlin {

    @GET("weather/current/{city}")
    fun getWeather(
            @Path("city") city:String,
            @Query("app_id") appid:String,
            @Query("app_secret") appsecret:String
    ) :Call<DayWeatherEntityKotlin>
}