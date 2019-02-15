package com.amthuc.nauan.congthuc.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *   Created by quangnv on 25/01/2019
 */

@Parcelize
data class Recipe(
    var name: String? = null,
    var img: String? = null,
    var level: String? = null,
    var title: String? = null,
    var des: String? = null,
    var time: Int = 30,
    var serving: Int = 4,
    @SerializedName("components") var ingredients: MutableList<Ingredient>? = null,
    @SerializedName("cook_steps") var cookSteps: MutableList<CookStep>? = null
) : Parcelable