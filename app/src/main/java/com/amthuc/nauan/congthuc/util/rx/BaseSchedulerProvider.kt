package com.amthuc.nauan.congthuc.util.rx

import androidx.annotation.NonNull
import io.reactivex.Scheduler

/**
 *   Created by quangnv on 29/01/2019
 */

interface BaseSchedulerProvider {

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler
}