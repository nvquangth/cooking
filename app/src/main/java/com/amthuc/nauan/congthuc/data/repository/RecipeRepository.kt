package com.amthuc.nauan.congthuc.data.repository

import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.data.source.RecipeDataSource
import io.reactivex.Observable

/**
 *   Created by quangnv on 25/01/2019
 */

class RecipeRepository(private val local: RecipeDataSource.Local) : RecipeDataSource.Local {
    override fun getRecipes(source: String): Observable<List<Recipe>> {
        return local.getRecipes(source)
    }

    override fun searchRecipes(q: String): Observable<List<Recipe>> {
        return local.searchRecipes(q)
    }
}