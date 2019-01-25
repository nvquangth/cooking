package com.amthuc.nauan.congthuc.data.source

import com.amthuc.nauan.congthuc.data.model.Category
import io.reactivex.Observable

/**
 *   Created by quangnv on 25/01/2019
 */

interface CategoryDataSource {

    /**
     * Local
     */
    interface Local {

        fun getCategories(source: String?): Observable<List<Category>>
    }
}