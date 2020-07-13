package com.example.smokestalks.main.menu

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smokestalks.R
import kotlinx.android.synthetic.main.categories_item.view.*
import kotlinx.android.synthetic.main.subcategories_item.view.*

class SubcategoriesAdapter: RecyclerView.Adapter<SubcategoriesAdapter.SubcategoriesViewHolder>() {

    private var checkedPosition = 0
    private var listener: Listener? = null

    private val menuList = listOf(
        "Rare",
        "Medium",
        "Well"
    )

    interface Listener {
        fun onItemClick(item: View, position: Int)
    }

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

    inner class  SubcategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String, listener: Listener?) {
            if (checkedPosition == -1) {
                itemView.subcategoriesTextView.setTextColor(Color.parseColor("#FFCC00"))
            } else {
                    itemView.subcategoriesTextView.setTextColor(Color.GRAY)
                }
           itemView.subcategoriesTextView.text = item
            itemView.subcategoriesItem.setOnClickListener {
                itemView.subcategoriesTextView.setTextColor(Color.parseColor("#FFCC00"))
                if (checkedPosition != adapterPosition) {
                    notifyItemChanged(checkedPosition)
                    checkedPosition = adapterPosition
                }
            }

        }
    }

    override fun onBindViewHolder(holder: SubcategoriesViewHolder, position: Int) {
        holder.bind(menuList[position], listener)
    }
}