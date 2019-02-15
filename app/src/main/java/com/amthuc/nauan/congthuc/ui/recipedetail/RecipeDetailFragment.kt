package com.amthuc.nauan.congthuc.ui.recipedetail

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.databinding.FragmentRecipeDetailBinding
import com.amthuc.nauan.congthuc.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_recipe_detail.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *   Created by quangnv on 14/02/2019
 */

class RecipeDetailFragment : BaseFragment<FragmentRecipeDetailBinding, RecipeDetailViewModel>() {

    private var recipe: Recipe? = null

    companion object {

        private const val ARGUMENT_RECIPE = "ARGUMENT_RECIPE"

        fun newInstance(recipe: Recipe): RecipeDetailFragment {
            val fragment = RecipeDetailFragment()
            val args = Bundle()
            args.putParcelable(ARGUMENT_RECIPE, recipe)
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutResource(): Int = R.layout.fragment_recipe_detail

    override fun initComponentOnCreateView() {
        recipe = arguments?.getParcelable(ARGUMENT_RECIPE)
    }

    override fun retrieveViewOrRestoreState() {
        val ingredientAdapter = get<IngredientAdapter>()
        val cookStepAdapter = get<CookStepAdapter>()
        val viewModel = getViewModel<RecipeDetailViewModel>()

        viewModel.setDataRecipe(recipe!!)

        viewModel.getDataRecipe().observe(this, Observer { recipe
            ingredientAdapter.refreshData(recipe?.ingredients!!)
            cookStepAdapter.refreshData(recipe?.cookSteps!!)
        })

        viewBinding.viewModel = viewModel
        lifecycle.addObserver(viewModel)

        recyclerIngredient.layoutManager = LinearLayoutManager(context)
        recyclerCookStep.layoutManager = LinearLayoutManager(context)
        recyclerIngredient.adapter = ingredientAdapter
        recyclerCookStep.adapter = cookStepAdapter

        viewModel.getDataRecipe()
    }
}