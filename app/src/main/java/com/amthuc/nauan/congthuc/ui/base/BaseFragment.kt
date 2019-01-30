package com.amthuc.nauan.congthuc.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel

/**
 *   Created by quangnv on 30/01/2019
 */

abstract class BaseFragment<VB : ViewDataBinding, VM : AndroidViewModel> : Fragment() {

    lateinit var viewBinding: VB
    lateinit var viewModel: VM


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, getLayoutResource(), container, false)
        viewBinding.setLifecycleOwner(this)
        initComponentOnCreateView()
        retainInstance = true
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retrieveViewOrRestoreState()
    }

    @LayoutRes
    abstract fun getLayoutResource(): Int

    abstract fun initComponentOnCreateView()

    abstract fun retrieveViewOrRestoreState()
}