package com.example.smokestalks.main.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smokestalks.R
import kotlinx.android.synthetic.main.categories_item.view.*
import kotlinx.android.synthetic.main.subcategories_item.view.*

class SubcategoriesAdapter: RecyclerView.Adapter<SubcategoriesAdapter.SubcategoriesViewHolder>() {

    private val menuList = listOf(
        "Rare",
        "Medium",
        "Well"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoriesViewHolder {
        return SubcategoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.subcategories_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class SubcategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) {
            itemView.subcategoriesTextView.text = item
        }
    }

    override fun onBindViewHolder(holder: SubcategoriesViewHolder, position: Int) {
        holder.bind(menuList[position])
    }
}