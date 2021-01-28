package com.example.recyclerview.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/5
 * @email xiaozihuan994@qq.com
 * @description .
 */
public interface WeatherService {

    @GET("weather.php")
    Call<WeatherEntity> getCity(@Query("location") String city);
}
