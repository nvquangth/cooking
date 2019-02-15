package com.amthuc.nauan.congthuc.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by quangnv on 25/01/2019
 */

@Parcelize
data class Category(
    var title: String? = null,
    var source: String? = null,
    var images: List<String>? = null,
    var recipes: Int = 0
) : Parcelable