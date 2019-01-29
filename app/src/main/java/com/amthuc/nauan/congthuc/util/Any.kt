package com.amthuc.nauan.congthuc.util

/**
 *   Created by quangnv on 29/01/2019
 */

inline fun <T: Any> T?.notNull(f: (it: T) -> Unit){
    if (this != null) f(this)
}