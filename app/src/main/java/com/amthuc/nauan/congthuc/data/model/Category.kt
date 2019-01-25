package com.amthuc.nauan.congthuc.data.model

/**
 *   Created by quangnv on 25/01/2019
 */

data class Category (
    var title: String? = null,
    var source: String? = null,
    var images: List<String>? = null,
    var recipes: Int = 0
)