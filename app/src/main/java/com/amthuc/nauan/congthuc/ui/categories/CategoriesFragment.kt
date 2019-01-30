package com.amthuc.nauan.congthuc.ui.categories

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.databinding.FragmentCategoriesBinding
import com.amthuc.nauan.congthuc.ui.base.BaseFragment
import com.amthuc.nauan.congthuc.ui.base.OnItemListener
import com.amthuc.nauan.congthuc.ui.main.MainActivity
import com.amthuc.nauan.congthuc.util.Constant
import com.amthuc.nauan.congthuc.util.recyclerview.SpacesItemDecoration
import kotlinx.android.synthetic.main.fragment_categories.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *   Created by quangnv on 30/01/2019
 */

class CategoriesFragment : BaseFragment<FragmentCategoriesBinding, CategoriesViewModel>(), OnItemListener<Category> {
    override fun onItemClick(item: Category, position: Int) {

    }

    companion object {
        fun newInstance(): CategoriesFragment {
            val fm = CategoriesFragment()
            val bundle = Bundle()
            fm.arguments = bundle
            return fm
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_categories

    override fun initComponentOnCreateView() {

    }

    override fun retrieveViewOrRestoreState() {
        val categoryAdapter = get<CategoryAdapter>()
        val viewModel = getViewModel<CategoriesViewModel>()

        viewModel.getDataCategories().observe(this, Observer { categories ->
            categoryAdapter.addData(categories)
        })

        viewBinding.viewModel = viewModel
        lifecycle.addObserver(viewModel)

        categoryAdapter.registerListener(this)
        recyclerCategory.adapter = categoryAdapter
        recyclerCategory.layoutManager = GridLayoutManager(context, Constant.GRID_RECYCLER_CATEGORY)
        recyclerCategory.addItemDecoration(SpacesItemDecoration(context!!))

        viewModel.getCategories()

        if (activity is MainActivity) {
            (activity as MainActivity).setupWithToolbar(toolbar)
        }
    }

}