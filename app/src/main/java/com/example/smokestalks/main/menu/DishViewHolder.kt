package com.example.smokestalks.main.menu

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.smokestalks.data.Dish
import kotlinx.android.synthetic.main.dish_item.view.*

class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(dish: Dish, listener: DishAdapter.Listener?) {

        itemView.dishNameTextView.text = dish.title
        itemView.consistTextView.text = dish.consist
        itemView.priceTextView.text = dish.price.toString() + "грн"
        itemView.wightTextView.text = dish.weight.toString() + "гр"
    }
    }