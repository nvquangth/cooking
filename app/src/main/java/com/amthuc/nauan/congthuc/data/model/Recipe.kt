package com.amthuc.nauan.congthuc.data.model

import com.google.gson.annotations.SerializedName

/**
 *   Created by quangnv on 25/01/2019
 */

data class Recipe(
    var name: String? = null,
    var img: String? = null,
    var level: String? = null,
    var title: String? = null,
    var des: String? = null,
    @SerializedName("components") var ingredients: List<Ingredient>? = null,
    @SerializedName("cook_steps") var cookSteps: List<CookStep>? = null
) {

    var time: Int = 0
    get() {
        if (field == 0) {
            field = 30
        }
        return field
    }

    var serving: Int = 0
    get() {
        if (field == 0) {
            field = 4
        }
        return field
    }
}