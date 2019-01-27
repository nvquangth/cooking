package com.amthuc.nauan.congthuc.data.source.local

import android.content.Context
import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.data.source.RecipeDataSource
import com.amthuc.nauan.congthuc.data.source.local.assets.AssetsHelper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable

/**
 *   Created by quangnv on 25/01/2019
 */

class RecipeLocalDataSource(private val context: Context) : RecipeDataSource.Local {
    override fun getRecipes(source: String): Observable<List<Recipe>> {
        return Observable.create { emitter ->
            val data = AssetsHelper(context).read(source)
            val result = Gson().fromJson<List<Recipe>>(data, object : TypeToken<List<Recipe>>() {}.type)
            if (result == null || result.isEmpty()) {
                emitter.onError(NullPointerException("Data is empty!"))
            } else {
                emitter.onNext(result)
                emitter.onComplete()
            }
        }
    }

    override fun searchRecipes(q: String): Observable<List<Recipe>> {
        return Observable.create { emitter ->
            emitter.onComplete()
        }
    }
}