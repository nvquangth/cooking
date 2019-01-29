package com.amthuc.nauan.congthuc.ui.base

/**
 *   Created by quangnv on 29/01/2019
 */

interface OnItemListener<T> {

    fun onItemClick(item: T, position: Int)
}