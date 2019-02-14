package com.amthuc.nauan.congthuc.ui.category

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.Recipe
import com.amthuc.nauan.congthuc.databinding.ItemRecipeBinding
import com.amthuc.nauan.congthuc.ui.base.BaseRecyclerViewAdapter
import com.amthuc.nauan.congthuc.ui.base.OnItemListener

/**
 *   Created by quangnv on 30/01/2019
 */

class RecipeAdapter(context: Context) : BaseRecyclerViewAdapter<Recipe, RecyclerView.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemRecipeBinding>(layoutInflater, R.layout.item_recipe, parent, false)
        return ItemViewHolder(binding, onItemListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bindData(listData[position])
        setAnim(holder.itemView, position)
    }

    class ItemViewHolder(
        private val binding: ItemRecipeBinding,
        private val onItemListener: OnItemListener<Recipe>?,
        private val itemViewModel: ItemRecipeViewModel = ItemRecipeViewModel(onItemListener)
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.viewModel = itemViewModel
        }

        fun bindData(recipe: Recipe) {
            itemViewModel.setData(recipe)
            itemViewModel.position = adapterPosition
            binding.executePendingBindings()
        }
    }
}