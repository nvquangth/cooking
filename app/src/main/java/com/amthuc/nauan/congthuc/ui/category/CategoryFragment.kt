package com.amthuc.nauan.congthuc.ui.category

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.databinding.FragmentCategoryBinding
import com.amthuc.nauan.congthuc.ui.base.BaseFragment
import com.amthuc.nauan.congthuc.ui.base.OnItemListener
import com.amthuc.nauan.congthuc.ui.main.NavigatorViewModel
import com.amthuc.nauan.congthuc.util.notNull
import kotlinx.android.synthetic.main.fragment_category.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *   Created by quangnv on 30/01/2019
 */

class CategoryFragment : BaseFragment<FragmentCategoryBinding, CategoryViewModel>(), OnItemListener<Recipe> {

    private var category: Category? = null
    private lateinit var navigatorViewModel: NavigatorViewModel

    companion object {
        private const val ARGUMENT_CATEGORY = "com.amthuc.nauan.congthuc.ARGUMENT_CATEGORY"

        fun newInstance(category: Category): CategoryFragment {
            val fm = CategoryFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARGUMENT_CATEGORY, category)
            fm.arguments = bundle
            return fm
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_category

    override fun initComponentOnCreateView() {
        arguments.notNull {
            category = it.getParcelable(ARGUMENT_CATEGORY)
        }
    }

    override fun retrieveViewOrRestoreState() {
        val recipeAdapter = get<RecipeAdapter>()
        navigatorViewModel = activity!!.getViewModel()
        viewModel = getViewModel()

        viewBinding.viewModel = viewModel

        viewModel.getDataRecipes().observe(this, Observer { recipes ->
            recipeAdapter.refreshData(recipes)
        })

        lifecycle.addObserver(viewModel)

        recipeAdapter.registerListener(this)
        recyclerRecipe.adapter = recipeAdapter
        recyclerRecipe.layoutManager = LinearLayoutManager(context)

        viewModel.getRecipes(category!!)
    }

    override fun onItemClick(item: Recipe, position: Int) {
        navigatorViewModel.openRecipeEvent.value = item
    }
}