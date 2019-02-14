package com.amthuc.nauan.congthuc.ui.recipedetail

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.amthuc.nauan.congthuc.BR
import com.amthuc.nauan.congthuc.data.model.Ingredient
import com.amthuc.nauan.congthuc.util.notNull

/**
 *   Created by quangnv on 14/02/2019
 */

data class ItemIngredientViewModel(
    @Bindable var ingredient: Ingredient? = null
) : BaseObservable() {

    fun setData(ingredient: Ingredient?) {
        ingredient.notNull {
            this.ingredient = it
            notifyPropertyChanged(BR.ingredient)
        }
    }
}