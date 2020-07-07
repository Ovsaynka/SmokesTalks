package com.example.smokestalks.main.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smokestalks.R
import com.example.smokestalks.data.Dish

class DishAdapter(private val dishesList: List<Dish>):  RecyclerView.Adapter<DishViewHolder>() {

    private var listener: Listener? = null

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(dishesList[position],listener)
    }

    interface Listener {
        fun onItemClick(dish: Dish)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        return DishViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dish_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dishesList.size
    }
}