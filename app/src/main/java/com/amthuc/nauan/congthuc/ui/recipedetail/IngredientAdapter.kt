package com.amthuc.nauan.congthuc.ui.recipedetail

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.Ingredient
import com.amthuc.nauan.congthuc.databinding.ItemIngredientBinding
import com.amthuc.nauan.congthuc.ui.base.BaseRecyclerViewAdapter

/**
 *   Created by quangnv on 14/02/2019
 */

class IngredientAdapter(context: Context) : BaseRecyclerViewAdapter<Ingredient, RecyclerView.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            DataBindingUtil.inflate<ItemIngredientBinding>(layoutInflater, R.layout.item_ingredient, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bindData(listData[position])
    }

    class ItemViewHolder(
        private val binding: ItemIngredientBinding,
        private val itemViewModel: ItemIngredientViewModel = ItemIngredientViewModel()
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.viewModel = itemViewModel
        }

        fun bindData(ingredient: Ingredient) {
            itemViewModel.setData(ingredient)
            binding.executePendingBindings()
        }
    }
}