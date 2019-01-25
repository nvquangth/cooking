package com.amthuc.nauan.congthuc.data.source.local.sharepref

/**
 *   Created by quangnv on 25/01/2019
 */

interface SharePrefsApi {

    fun <T> get(key: String, clazz: Class<T>): T?

    fun <T> put(key: String, data: T)

    fun delete(key: String)

    fun clear()
}
