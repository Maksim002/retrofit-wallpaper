package com.example.retrafitservise.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class WallModel {
    @SerializedName("urls")
    @Expose
    var urls: Urls? = null
}