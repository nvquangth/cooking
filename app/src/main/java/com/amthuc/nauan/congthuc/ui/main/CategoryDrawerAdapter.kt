package com.amthuc.nauan.congthuc.ui.main

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.databinding.ItemCategoryDrawerBinding
import com.amthuc.nauan.congthuc.ui.base.BaseRecyclerViewAdapter
import com.amthuc.nauan.congthuc.ui.base.OnItemListener

/**
 *   Created by quangnv on 29/01/2019
 */

class CategoryDrawerAdapter(context: Context) : BaseRecyclerViewAdapter<Category, RecyclerView.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemCategoryDrawerBinding>(
            layoutInflater, R.layout.item_category_drawer, parent, false
        )
        return ItemViewHolder(binding, onItemListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bindData(listData[position])
    }

    inner class ItemViewHolder(
        private val binding: ItemCategoryDrawerBinding,
        private val onItemListener: OnItemListener<Category>?,
        private val itemViewModel: ItemCategoryDrawerViewModel = ItemCategoryDrawerViewModel(
            onItemListener
        )
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.viewModel = itemViewModel
        }

        fun bindData(category: Category) {
            itemViewModel.setData(category)
            itemViewModel.position = adapterPosition
            binding.executePendingBindings()
        }
    }
}