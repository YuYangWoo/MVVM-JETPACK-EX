package com.example.flow.ui.adapter

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.flow.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("thumbnail")
    fun setThumbnail(imageView: ImageView, url: String) {
        try {
            url?.let { url ->
                Glide.with(imageView).load(url).error(R.drawable.no_image).placeholder(R.drawable.no_image).into(imageView)
            }
        } catch (e: Exception) {
            Log.d("TAG", e.message.toString())
        }
    }
}
