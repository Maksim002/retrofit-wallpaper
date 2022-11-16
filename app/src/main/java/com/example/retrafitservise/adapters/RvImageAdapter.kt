package com.example.retrafitservise.adapters

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.provider.ContactsContract.Contacts.Photo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.retrafitservise.R
import com.example.retrafitservise.retrofit.model.Urls
import com.example.retrafitservise.retrofit.model.WallModel
import kotlinx.android.synthetic.main.item_photo.view.*

class RvImageAdapter(private var list: ArrayList<WallModel> = arrayListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun update(setList: ArrayList<WallModel>){
        list = setList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ViewHolder(holder.itemView).bind(list[position], holder)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(item : WallModel ,holder: RecyclerView.ViewHolder) = with(holder.itemView){
            // Загружаем картинку
            item.urls?.let {
                Glide.with(this)
                    .asBitmap()
                    .load(item.urls!!.small.toString())
                    .into(object : CustomTarget<Bitmap>(){
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            photoConvertor(resource, holder)
                        }
                        override fun onLoadCleared(placeholder: Drawable?) {}
                    })
            }
        }

        fun photoConvertor(bitmap: Bitmap, holder: RecyclerView.ViewHolder) = with(holder.itemView){
           if (bitmap.width < bitmap.height){
               itemVertical.isVisible = true
               itemHorizontal.isVisible = false
               itemVertical.setImageBitmap(bitmap)
            }else{
               itemHorizontal.isVisible = true
               itemVertical.isVisible = false
               itemHorizontal.setImageBitmap(bitmap)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}