package com.lyj.retrofitstudy.network.api;

import com.lyj.retrofitstudy.javaBean.WeatherEntry;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/10/27.
 */

public interface WeatherApi
{
    @Headers("Authorization:APPCODE 2594043e836740c788019fdbdc11a8b3")
    @GET("weather/query")
    Call<WeatherEntry> weatherQuery(@Query("city") String city, @Query("cityid") String cityId, @Query("citycode") String cityCode);
}
