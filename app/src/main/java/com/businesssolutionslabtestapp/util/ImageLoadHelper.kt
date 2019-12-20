package com.businesssolutionslabtestapp.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun loadPicture(imageView: ImageView, url: String) {

    Picasso.with(imageView.context)
        .load(url)
        .noFade()
        .centerCrop()
        .fit()
        .into(imageView)
}

fun loadPictureWithoutCrop(imageView: ImageView, url: String) {

    Picasso.with(imageView.context)
        .load(url)
        .noFade()
        .centerInside()
        .fit()
        .into(imageView)
}