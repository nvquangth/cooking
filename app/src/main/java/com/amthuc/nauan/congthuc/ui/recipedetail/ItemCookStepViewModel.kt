package com.amthuc.nauan.congthuc.ui.recipedetail

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.amthuc.nauan.congthuc.BR
import com.amthuc.nauan.congthuc.data.model.CookStep
import com.amthuc.nauan.congthuc.util.notNull

/**
 *   Created by quangnv on 14/02/2019
 */

data class ItemCookStepViewModel(
    @Bindable var cookStep: CookStep? = null
) : BaseObservable() {

    fun setData(cookStep: CookStep?) {
        cookStep.notNull {
            this.cookStep = it
            notifyPropertyChanged(BR.cookStep)
        }
    }
}