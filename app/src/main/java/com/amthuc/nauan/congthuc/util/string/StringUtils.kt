package com.amthuc.nauan.congthuc.util.string

import java.lang.StringBuilder

/**
 *   Created by quangnv on 29/01/2019
 */

class StringUtils {

    fun isEmpty(str: String?): Boolean = str == null || str.isEmpty() || str.trim().isEmpty()

    fun append(vararg strs: String?): String {
        val stringBuilder = StringBuilder()
        for (str in strs) {
            stringBuilder.append(str)
        }
        return stringBuilder.toString()
    }
}