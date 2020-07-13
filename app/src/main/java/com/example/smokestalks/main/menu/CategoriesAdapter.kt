package com.example.smokestalks.main.menu

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smokestalks.R
import kotlinx.android.synthetic.main.categories_item.view.*

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var checkedPosition = 0
   private var listener: Listener? = null

    private val categoriesList = listOf(
        "Напитки",
        "Десерты",
        "Горячее",
        "Гриль",
        "Салаты",
        "Закуски"
    )

    interface Listener {
        fun onItemClick(item: View, position: Int)
    }

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
    inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("ResourceAsColor")
        fun bind(item: String, listener: Listener?) {
            if (checkedPosition == -1) {
                itemView.indicatorImageView.visibility = View.GONE
            } else {
                if (checkedPosition == adapterPosition) {
                    itemView.indicatorImageView.visibility = View.VISIBLE
                } else {
                    itemView.indicatorImageView.visibility = View.GONE
                    itemView.menuTextView.setTextColor(Color.GRAY)
                }
            }
            itemView.menuTextView.text = item
            itemView.categoriesItem.setOnClickListener {
                itemView.indicatorImageView.visibility = View.VISIBLE
                itemView.menuTextView.setTextColor(Color.parseColor("#FFCC00"))
                itemView.indicatorImageView.setImageResource(R.drawable.indicator_icon)
                if (checkedPosition != adapterPosition) {
                    notifyItemChanged(checkedPosition)
                    checkedPosition = adapterPosition
                }
            }
        }
        }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.apply {
            bind(categoriesList[position], listener)
        }
    }
}