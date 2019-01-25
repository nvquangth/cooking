package com.amthuc.nauan.congthuc.data.repository

import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.data.source.CategoryDataSource
import io.reactivex.Observable

/**
 *   Created by quangnv on 25/01/2019
 */

class CategoryRepository(private val local: CategoryDataSource.Local): CategoryDataSource.Local {
    override fun getCategories(source: String?): Observable<List<Category>> {
        return local.getCategories(source)
    }
}