package com.example.retrafitservise.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.retrafitservise.retrofit.manager.WallpaperManager
import com.example.retrafitservise.retrofit.model.WallModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(var presente: ViewPresenter) : ViewModel() {
    private var host: String = "gW9sjuasObbkxughhFTiEftk-SjD7OuVSvI5aP7bRG4"
    private var key: String = "oqZ_uR-OVEfpANEHtz-u-DXjdR5lyGzMkBl-yKf-4dY"

    fun create() {
        photo(1)
    }

    private fun photo(int: Int) {
        val service = WallpaperManager.setupRetrofit()
        service.getMealPlanse(host, key, int)
            .enqueue(object : Callback<List<WallModel>> {
                @RequiresApi(Build.VERSION_CODES.M)
                override fun onResponse(call: Call<List<WallModel>>, response: Response<List<WallModel>>) {
                    //200
                    presente.getPhoto(response.body() ?: arrayListOf())
                }

                override fun onFailure(call: Call<List<WallModel>>, t: Throwable) {
                    //400/500/300
                    t.printStackTrace()
                }
            })
    }

    fun restart(int: Int) = photo(int)
}