package com.example.recyclerview.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/20
 * @email xiaozihuan994@qq.com
 * @description .
 */
public interface TideService {

    @GET("v3/tide/daily.json")
    Call<TideEntity> getTideData(@Query("key") String key,@Query("location") String location);
}
