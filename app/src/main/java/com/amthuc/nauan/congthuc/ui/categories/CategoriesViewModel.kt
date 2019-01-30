package com.amthuc.nauan.congthuc.ui.categories

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.data.repository.CategoryRepository
import com.amthuc.nauan.congthuc.ui.base.BaseViewModel
import com.amthuc.nauan.congthuc.util.Constant
import com.amthuc.nauan.congthuc.util.rx.BaseSchedulerProvider
import org.koin.android.ext.android.get

/**
 *   Created by quangnv on 30/01/2019
 */

class CategoriesViewModel(application: Application) : BaseViewModel(application) {

    private val categoryRepository = application.get<CategoryRepository>()
    private val scheduler = application.get<BaseSchedulerProvider>()
    private val categories: MutableLiveData<MutableList<Category>> = MutableLiveData()

    fun getCategories() {
        val disposable = categoryRepository.getCategories(Constant.CATEGORIES_PATH)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe({ data -> categories.value = data.toMutableList() }, { throwable -> })
        compositeDisposable.addAll(disposable)
    }

    fun getDataCategories(): MutableLiveData<MutableList<Category>> = categories
}