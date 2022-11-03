package com.example.retrafitservise.main

import com.example.retrafitservise.retrofit.model.WallModel

interface ViewPresenter {
    fun getPhoto(photo: List<WallModel>)
}
