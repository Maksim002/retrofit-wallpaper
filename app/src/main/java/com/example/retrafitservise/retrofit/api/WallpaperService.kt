package com.example.retrafitservise.retrofit.api

import com.example.retrafitservise.retrofit.model.WallModel
import retrofit2.Call
import retrofit2.http.*

interface WallpaperService {
    @GET("/photos")
    fun getMealPlanse(
        @Query("client_id") host: String,
        @Query("redirect_uri") key: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int = 100
    ): Call<List<WallModel>>
}