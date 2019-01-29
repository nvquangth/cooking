package com.amthuc.nauan.congthuc.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import io.reactivex.disposables.CompositeDisposable

/**
 *   Created by quangnv on 28/01/2019
 */

open class BaseViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver {

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}