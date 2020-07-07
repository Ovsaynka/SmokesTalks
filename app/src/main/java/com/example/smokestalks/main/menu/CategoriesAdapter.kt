package com.example.smokestalks.main.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smokestalks.R
import kotlinx.android.synthetic.main.categories_item.view.*

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

   // private var selectedItem:

    private val categoriesList = listOf(
        "Напитки",
        "Десерты",
        "Горячее",
        "Гриль",
        "Салаты",
        "Закуски"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.categories_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) {
            itemView.menuTextView.text = item
        }
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categoriesList[position])
    }
}