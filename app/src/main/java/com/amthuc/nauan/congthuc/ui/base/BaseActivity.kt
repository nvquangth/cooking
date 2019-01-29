package com.amthuc.nauan.congthuc.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 *   Created by quangnv on 28/01/2019
 */

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    lateinit var viewBinding: VB
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, getLayoutResource())
        viewBinding.setLifecycleOwner(this)
        initComponentOnCreate()
        retrieveViewOrRestoreState()
    }

    abstract fun getLayoutResource(): Int

    abstract fun initComponentOnCreate()

    abstract fun retrieveViewOrRestoreState()

    fun toast(msg: String?) {
        Toast.makeText(applicationContext, msg!!, Toast.LENGTH_SHORT).show()
    }
}
