package com.amthuc.nauan.congthuc.ui.categories

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.Category
import com.amthuc.nauan.congthuc.databinding.ItemCategoriesBinding
import com.amthuc.nauan.congthuc.ui.base.BaseRecyclerViewAdapter
import com.amthuc.nauan.congthuc.ui.base.OnItemListener

/**
 *   Created by quangnv on 30/01/2019
 */

class CategoryAdapter(context: Context) : BaseRecyclerViewAdapter<Category, RecyclerView.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemCategoriesBinding>(
            layoutInflater, R.layout.item_categories, parent,
            false
        )
        return ItemViewHolder(binding, onItemListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bindData(listData[position])
    }

    class ItemViewHolder(
        private val binding: ItemCategoriesBinding,
        private val onItemListener: OnItemListener<Category>?,
        private val itemViewModel: ItemCategoryViewModel = ItemCategoryViewModel(onItemListener)
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.viewModel = itemViewModel
        }

        fun bindData(category: Category) {
            itemViewModel.setData(category)
            itemViewModel.positon = adapterPosition
            binding.executePendingBindings()
        }
    }
}