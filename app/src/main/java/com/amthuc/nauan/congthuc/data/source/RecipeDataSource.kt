package com.amthuc.nauan.congthuc.data.source

import com.amthuc.nauan.congthuc.data.model.Recipe
import io.reactivex.Observable

/**
 *   Created by quangnv on 25/01/2019
 */

interface RecipeDataSource {

    /**
     * Local
     */
    interface Local {
        fun getRecipes(source: String): Observable<List<Recipe>>

        fun searchRecipes(q: String): Observable<List<Recipe>>
    }
}