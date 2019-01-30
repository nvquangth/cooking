package com.amthuc.nauan.congthuc.util.app

import android.content.Context
import android.util.TypedValue

/**
 *   Created by quangnv on 30/01/2019
 */

class AppUtils {

    fun dpToPx(context: Context, dp: Float): Int {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics))
    }
}