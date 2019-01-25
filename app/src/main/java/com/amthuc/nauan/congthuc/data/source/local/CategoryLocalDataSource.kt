package com.amthuc.nauan.congthuc.data.source.local

import android.content.Context
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.data.source.CategoryDataSource
import com.amthuc.nauan.congthuc.data.source.local.assets.AssetsHelper
import com.amthuc.nauan.congthuc.util.Constant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable

/**
 *   Created by quangnv on 25/01/2019
 */

class CategoryLocalDataSource(private val context: Context) : CategoryDataSource.Local {

    override fun getCategories(source: String?): Observable<List<Category>> {
        return Observable.create { emitter ->
            val data = AssetsHelper(context).read(Constant.CATEGORIES_PATH)
            val result = Gson().fromJson<List<Category>>(data, object : TypeToken<List<Category>>() {}.type)
            if (result == null || result.isEmpty()) {
                emitter.onError(NullPointerException("Data is empty!"))
            } else {
                emitter.onNext(result)
                emitter.onComplete()
            }
        }
    }
}