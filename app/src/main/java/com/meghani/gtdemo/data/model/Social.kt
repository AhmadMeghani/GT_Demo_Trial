package com.meghani.gtdemo.data.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide

@Entity(tableName = "socials")
data class Social(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val icon_url: String,
    val name: String,
    val package_name_android: String,
    val url: String
)

@BindingAdapter("imageUrl")
fun setImageUrl(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .into(imgView)
    }
}