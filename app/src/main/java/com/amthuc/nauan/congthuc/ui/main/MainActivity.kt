package com.amthuc.nauan.congthuc.ui.main

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.databinding.ActivityMainBinding
import com.amthuc.nauan.congthuc.ui.base.BaseActivity
import com.amthuc.nauan.congthuc.ui.base.OnItemListener
import com.amthuc.nauan.congthuc.ui.categories.CategoriesFragment
import com.amthuc.nauan.congthuc.ui.category.CategoryFragment
import com.amthuc.nauan.congthuc.ui.recipedetail.RecipeDetailFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    OnItemListener<Category>, CategoryFragment.OnItemRecipeListener {
    override fun onItemRecipeClick(recipe: Recipe) {
        replaceFragment(RecipeDetailFragment.newInstance(recipe), true)
    }

    override fun onItemClick(item: Category, position: Int) {
        replaceFragment(CategoryFragment.newInstance(item), true)
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
    }

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun retrieveViewOrRestoreState() {
        val categoryAdapter = get<CategoryDrawerAdapter>()
        viewModel = getViewModel()

        viewBinding.viewModel = viewModel

        viewModel.getDataCategories().observe(this, Observer { categories ->
            categoryAdapter.addData(categories)
        })

//        viewModel.getOpenRecipeEvent().observe(this, Observer { recipe ->
//            Log.d("fff", "yyyyy")
//        })
//        lifecycle.addObserver(viewModel)

        categoryAdapter.registerListener(this)
        recyclerCategoryDrawer.adapter = categoryAdapter
        recyclerCategoryDrawer.layoutManager = LinearLayoutManager(applicationContext)
        recyclerCategoryDrawer.addItemDecoration(
            DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        )

        viewModel.getCategories()

        addFragment(CategoriesFragment.newInstance(), false)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun setupWithToolbar(toolbar: Toolbar) {
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }
}
