package com.amthuc.nauan.congthuc.util.recyclerview

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amthuc.nauan.congthuc.util.Constant
import com.amthuc.nauan.congthuc.util.app.AppUtils

/**
 *   Created by quangnv on 30/01/2019
 */

class SpacesItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private var space: Int = AppUtils().dpToPx(context, Constant.SPACE_CATEGORY)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        if (position % 2 != 0) {
            outRect.left = space / 2
            outRect.right = space
            outRect.bottom = 0
            outRect.top = space
        } else {
            outRect.left = space
            outRect.right = space / 2
            outRect.bottom = 0
            outRect.top = space
        }
    }
}