package com.example.testchucknorris.mainModule.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testchucknorris.databinding.IteamCategoriesBinding

class CategoriesAdapter( private val onClickListener: (category: String) -> Unit) :
    ListAdapter<String, CategoriesAdapter.CategoryViewHolder>(categoryDiffCall()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryBinding =
            IteamCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)

        return CategoryViewHolder(categoryBinding, onClickListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
    }

    class CategoryViewHolder(
        private val iteamCategoriesBinding: IteamCategoriesBinding,
        private val onClickListener: (category: String) -> Unit
    ) :
        RecyclerView.ViewHolder(iteamCategoriesBinding.root) {
        fun bind(category: String) {
            iteamCategoriesBinding.recyclerViewCategories.text = category
            iteamCategoriesBinding.container.setOnClickListener {
                onClickListener(category)
            }
        }
    }

    class categoryDiffCall : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem
    }
}