package com.example.recyclerview.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/25
 * @email xiaozihuan994@qq.com
 * @description .
 */
public interface ImageService {

    @GET("image/girl/list")
    Call<ImageEntity> getCount(@Query("page") int page, @Query("app_id") String appid,@Query("app_secret") String appsecret);

}
