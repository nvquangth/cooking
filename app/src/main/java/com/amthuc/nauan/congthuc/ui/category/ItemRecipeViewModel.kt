package com.amthuc.nauan.congthuc.ui.category

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.amthuc.nauan.congthuc.BR
import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.ui.base.OnItemListener
import com.amthuc.nauan.congthuc.util.notNull

/**
 *   Created by quangnv on 30/01/2019
 */

data class ItemRecipeViewModel(
    val onItemListener: OnItemListener<Recipe>? = null,
    var position: Int = 0,
    @Bindable var recipe: Recipe? = null
) : BaseObservable() {

    fun setData(recipe: Recipe?) {
        recipe.notNull { it->
            this.recipe = it
            notifyPropertyChanged(BR.recipe)
        }
    }

    fun onItemClick() {
        onItemListener.notNull { it->
            it.onItemClick(recipe!!, position)
        }
    }
}