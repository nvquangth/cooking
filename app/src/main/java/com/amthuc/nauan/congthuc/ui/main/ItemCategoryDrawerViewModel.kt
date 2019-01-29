package com.amthuc.nauan.congthuc.ui.main

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.ui.base.OnItemListener
import com.amthuc.nauan.congthuc.util.notNull

/**
 *   Created by quangnv on 29/01/2019
 */

data class ItemCategoryDrawerViewModel(
    val onItemListener: OnItemListener<Category>? = null,
    var position: Int = 0,
    @Bindable var category: Category? = null
) : BaseObservable() {

    fun setData(category: Category?) {
        category.notNull { it ->
            this.category = it
            notifyPropertyChanged(BR.category)
        }
    }

    fun onItemClick() {
        onItemListener.notNull { it ->
            it.onItemClick(category!!, position)
        }
    }
}