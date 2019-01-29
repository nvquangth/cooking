package com.amthuc.nauan.congthuc

import android.app.Application
import com.amthuc.nauan.congthuc.di.appModule
import org.koin.android.ext.android.startKoin

/**
 *   Created by quangnv on 29/01/2019
 */

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin context
        startKoin(this, appModule)
    }
}