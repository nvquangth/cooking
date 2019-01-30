package com.amthuc.nauan.congthuc.di

import com.amthuc.nauan.congthuc.data.repository.CategoryRepository
import com.amthuc.nauan.congthuc.data.repository.RecipeRepository
import com.amthuc.nauan.congthuc.data.source.CategoryDataSource
import com.amthuc.nauan.congthuc.data.source.RecipeDataSource
import com.amthuc.nauan.congthuc.data.source.local.CategoryLocalDataSource
import com.amthuc.nauan.congthuc.data.source.local.RecipeLocalDataSource
import com.amthuc.nauan.congthuc.ui.categories.CategoriesViewModel
import com.amthuc.nauan.congthuc.ui.categories.CategoryAdapter
import com.amthuc.nauan.congthuc.ui.category.CategoryViewModel
import com.amthuc.nauan.congthuc.ui.category.RecipeAdapter
import com.amthuc.nauan.congthuc.ui.main.CategoryDrawerAdapter
import com.amthuc.nauan.congthuc.ui.main.MainViewModel
import com.amthuc.nauan.congthuc.util.rx.BaseSchedulerProvider
import com.amthuc.nauan.congthuc.util.rx.SchedulerProvider
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

/**
 *   Created by quangnv on 29/01/2019
 */

val viewModelModule = module {
    viewModel<MainViewModel>()
    viewModel<CategoriesViewModel>()
    viewModel<CategoryViewModel>()
}

val localDataSourceModule = module {
    single<RecipeDataSource.Local> { RecipeLocalDataSource(androidContext()) }
    single<CategoryDataSource.Local> { CategoryLocalDataSource(androidContext()) }
}

val repositoryModule = module {
    single { RecipeRepository(get()) }
    single { CategoryRepository(get()) }
}

val rxModule = module {
    single<BaseSchedulerProvider> { SchedulerProvider() }
}

val adapterModule = module {
    single { CategoryDrawerAdapter(get()) }
    single { CategoryAdapter(get()) }
    single { RecipeAdapter(get()) }
}

val appModule = listOf(
    viewModelModule,
    localDataSourceModule,
    repositoryModule,
    rxModule,
    adapterModule
)