package com.example.retrafitservise.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.retrafitservise.R
import com.example.retrafitservise.adapters.RvImageAdapter
import com.example.retrafitservise.retrofit.model.WallModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewPresenter{

    private var viewModel = MainViewModel(this)
    private var myAdapter = RvImageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_image.adapter = myAdapter
    }

    override fun getPhoto(photo: List<WallModel>) {
        myAdapter.update(photo as ArrayList<WallModel>)
    }

    override fun onStart() {
        super.onStart()
        viewModel.create()
    }
}