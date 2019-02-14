package com.amthuc.nauan.congthuc.ui.recipedetail

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amthuc.nauan.congthuc.R
import com.amthuc.nauan.congthuc.data.model.CookStep
import com.amthuc.nauan.congthuc.databinding.ItemCookStepBinding
import com.amthuc.nauan.congthuc.ui.base.BaseRecyclerViewAdapter

/**
 *   Created by quangnv on 14/02/2019
 */

class CookStepAdapter(context: Context) : BaseRecyclerViewAdapter<CookStep, RecyclerView.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            DataBindingUtil.inflate<ItemCookStepBinding>(layoutInflater, R.layout.item_cook_step, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bindData(listData[position])
    }

    class ItemViewHolder(
        private val binding: ItemCookStepBinding,
        private val itemViewModel: ItemCookStepViewModel = ItemCookStepViewModel()
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(cookStep: CookStep) {
            itemViewModel.setData(cookStep)
            binding.executePendingBindings()
        }
    }
}