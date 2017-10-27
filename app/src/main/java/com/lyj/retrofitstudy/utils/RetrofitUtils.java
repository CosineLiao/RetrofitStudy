package com.lyj.retrofitstudy.utils;

import com.lyj.retrofitstudy.javaBean.WeatherEntry;
import com.lyj.retrofitstudy.network.ApiService;

import retrofit2.Call;

/**
 * Created by Administrator on 2017/10/27.
 */

public class RetrofitUtils
{
    public static Call<WeatherEntry> requestWeatherCall(String city, String cityId, String cityCode) {
        return ApiService.SingletonHolder.getInstance().getWeatherApi().weatherQuery(city, cityId, cityCode);
    }
}
