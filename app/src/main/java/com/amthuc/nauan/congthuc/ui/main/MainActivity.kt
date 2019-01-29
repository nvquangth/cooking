package com.amthuc.nauan.congthuc.ui.main

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.databinding.ActivityMainBinding
import com.amthuc.nauan.congthuc.ui.base.BaseActivity
import com.amthuc.nauan.congthuc.ui.base.OnItemListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), OnItemListener<Category> {
    override fun onItemClick(item: Category, position: Int) {

    }

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun initComponentOnCreate() {
    }

    override fun retrieveViewOrRestoreState() {
        val categoryAdapter = get<CategoryAdapter>()
        val viewModel = getViewModel<MainViewModel>()

        viewModel.getDataCategories().observe(this, Observer { categories ->
            categoryAdapter.addData(categories)
        })

        viewBinding.viewModel = viewModel
        lifecycle.addObserver(viewModel)

        categoryAdapter.registerListener(this)
        recyclerCategoryDrawer.adapter = categoryAdapter
        recyclerCategoryDrawer.layoutManager = LinearLayoutManager(applicationContext)
        recyclerCategoryDrawer.addItemDecoration(
            DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        )

        viewModel.getCategories()
    }

//    override fun onBackPressed() {
//        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
//            drawer_layout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }
//
//    fun setupWithToolbar(toolbar: Toolbar) {
//        val toggle = ActionBarDrawerToggle(
//            this, drawer_layout, toolbar,
//            R.string.navigation_drawer_open,
//            R.string.navigation_drawer_close
//        )
//        drawer_layout.addDrawerListener(toggle)
//        toggle.syncState()
//    }
}
