package com.lyj.retrofitstudy.network;

import com.lyj.retrofitstudy.network.api.WeatherApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/10/27.
 */

public class ApiService
{
    private static final String BASE_URL = "http://jisutianqi.market.alicloudapi.com/";
    private Retrofit mRetrofit;

    public static class SingletonHolder {
        private static ApiService mInstance = new ApiService();
        public static ApiService getInstance() {
            if (mInstance.mRetrofit == null) {
                mInstance.mRetrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return mInstance;
        }
    }

    public WeatherApi getWeatherApi() {
        if (mRetrofit != null) {
            return mRetrofit.create(WeatherApi.class);
        }
        return null;
    }
}
