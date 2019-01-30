package com.amthuc.nauan.congthuc.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.amthuc.nauan.congthuc.R

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
        retrieveViewOrRestoreState()
    }

    @LayoutRes
    abstract fun getLayoutResource(): Int

    abstract fun retrieveViewOrRestoreState()

    protected fun toast(msg: String?) {
        Toast.makeText(applicationContext, msg!!, Toast.LENGTH_SHORT).show()
    }

    protected fun addFragment(fragment: Fragment, isAddToBackStack: Boolean) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        if (isAddToBackStack) transaction.addToBackStack(null)
        transaction.add(R.id.frame_container, fragment, null)
        transaction.commit()
    }

    protected fun replaceFragment(fragment: Fragment, isAddToBackStack: Boolean) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        if (isAddToBackStack) transaction.addToBackStack(null)
        transaction.add(R.id.frame_container, fragment, null)
        transaction.commit()
    }
}
