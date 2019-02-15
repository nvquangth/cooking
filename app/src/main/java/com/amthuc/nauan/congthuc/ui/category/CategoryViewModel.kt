package com.amthuc.nauan.congthuc.ui.category

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.data.repository.RecipeRepository
import com.amthuc.nauan.congthuc.ui.base.BaseViewModel
import com.amthuc.nauan.congthuc.ui.main.MainViewModel
import com.amthuc.nauan.congthuc.util.rx.BaseSchedulerProvider
import org.koin.android.ext.android.get

/**
 *   Created by quangnv on 30/01/2019
 */

class CategoryViewModel(application: Application) : MainViewModel(application) {

    private val recipeRepository = application.get<RecipeRepository>()
    private val scheduler = application.get<BaseSchedulerProvider>()
    private val recipes: MutableLiveData<MutableList<Recipe>> = MutableLiveData()
    var observableField: ObservableField<Category> = ObservableField()

    fun getRecipes(category: Category) {
        observableField.set(category)
        val disposable = recipeRepository.getRecipes(category.source!!)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe({ data -> recipes.value = data.toMutableList() }, { throwable -> })
        compositeDisposable.add(disposable)
    }

    fun getDataRecipes(): MutableLiveData<MutableList<Recipe>> = recipes
}