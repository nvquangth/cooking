package com.amthuc.nauan.congthuc.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by quangnv on 25/01/2019
 */

@Parcelize
data class CookStep (
    var step: Int = 0,
    var des: String? = null,
    var pictures: List<String>? = null
) : Parcelable