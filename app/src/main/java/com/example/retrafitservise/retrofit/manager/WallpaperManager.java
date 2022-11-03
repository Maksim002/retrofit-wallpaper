package com.example.retrafitservise.retrofit.manager;

import com.example.retrafitservise.retrofit.api.WallpaperService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WallpaperManager {

    //Создание OkHttpClient, который отвечает за рутиную обработку данных
    private static OkHttpClient okHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .build();
    }
    // отвечает за отображение данных на мобилке
    private static HttpLoggingInterceptor getInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
    //сам Retrofit
    public static WallpaperService setupRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient())
                .build().create(WallpaperService.class);
    }
}
