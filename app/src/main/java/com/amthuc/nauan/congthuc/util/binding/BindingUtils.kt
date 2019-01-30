package com.amthuc.nauan.congthuc.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.amthuc.nauan.congthuc.util.Constant
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 *   Created by quangnv on 30/01/2019
 */

object BindingUtils {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("imageUrlCrop")
    fun setImageUrlCrop(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(Constant.RADIUS_CATEGORY_IMAGE)))
            .into(imageView)
    }
}