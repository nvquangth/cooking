package com.amthuc.nauan.congthuc.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.util.notNull

/**
 *   Created by quangnv on 28/01/2019
 */

abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder> constructor(
    protected val context: Context,
    protected var layoutInflater: LayoutInflater = LayoutInflater.from(context),
    protected var listData: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<VH>() {
    protected var onItemListener: OnItemListener<T>? = null
    private var lastPosition = -1

    override fun getItemCount(): Int {
        return listData.size
    }

    protected open fun setAnim(view: View, position: Int) {
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_fall_bottom)
            view.startAnimation(animation)
            lastPosition = position
        }
    }

    fun getData(): MutableList<T> {
        return listData
    }

    fun refreshData(data: MutableList<T>) {
        data.notNull { it ->
            listData.clear()
            listData.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun addData(data: MutableList<T>) {
        data.notNull {
            listData.addAll(data)
            notifyItemChanged(listData.size, it.size)
        }
    }

    fun registerListener(onItemListener: OnItemListener<T>) {
        this.onItemListener = onItemListener
    }
}