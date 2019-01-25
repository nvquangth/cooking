package com.amthuc.nauan.congthuc.data.source.local.assets

import android.content.Context

/**
 *   Created by quangnv on 25/01/2019
 */

class AssetsHelper (private val context: Context) {

    fun read(source: String): String {
        return context.assets.open(source).bufferedReader().use { it.readText() }
    }
}