package com.amthuc.nauan.congthuc.ui.main

import androidx.lifecycle.ViewModel
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.util.SingleLiveEvent

/**
 *   Created by quangnv on 16/02/2019
 */

class NavigatorViewModel(
    val openCategoryEvent: SingleLiveEvent<Category> = SingleLiveEvent(),
    val openRecipeEvent: SingleLiveEvent<Recipe> = SingleLiveEvent()
) : ViewModel()