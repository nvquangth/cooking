package com.amthuc.nauan.congthuc.ui.recipedetail

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.ui.base.BaseViewModel

/**
 *   Created by quangnv on 14/02/2019
 */

class RecipeDetailViewModel(application: Application): BaseViewModel(application) {

    private val recipe: MutableLiveData<Recipe> = MutableLiveData()
    var observableField: ObservableField<Recipe> = ObservableField()

    fun setDataRecipe(recipe: Recipe) {
        observableField.set(recipe)
        this.recipe.value = recipe
    }

    fun getDataRecipe() = recipe
}