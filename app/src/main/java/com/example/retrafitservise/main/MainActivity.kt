package com.example.retrafitservise.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.retrafitservise.R
import com.example.retrafitservise.retrofit.model.WallModel

class MainActivity : AppCompatActivity(), ViewPresenter{

    private var viewModel = MainViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var page = 1
        this.findViewById<TextView>(R.id.wwww).setOnClickListener {
            viewModel.restart(page)
            page ++
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.create()
    }

    override fun getPhoto(photo: List<WallModel>) {
        photo
    }
}