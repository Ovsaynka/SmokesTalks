package com.example.smokestalks.main.menu

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.smokestalks.data.Dish
import com.example.smokestalks.main.Visibility
import kotlinx.android.synthetic.main.dish_item.*
import kotlinx.android.synthetic.main.dish_item.view.*
import kotlinx.android.synthetic.main.dish_item.view.addButton
import kotlinx.android.synthetic.main.menu_navigation_button.view.*

class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var count = 1
    @SuppressLint("SetTextI18n")
    fun bind(dish: Dish, listener: DishAdapter.Listener?) {
        itemView.dishNameTextView.text = dish.title
        itemView.consistTextView.text = dish.consist
        itemView.priceTextView.text = dish.price.toString() + "грн"
        itemView.wightTextView.text = dish.weight.toString() + "гр"
        itemView.bottomLinearLayout.visibility = View.GONE
        itemView.addButton.setOnClickListener {
            itemView.bottomLinearLayout.visibility = View.VISIBLE
            itemView.countTextView.text = count.toString() + "x"
            itemView.bottomLinearLayout.minusButton.setOnClickListener {
                if(count > 1) {
                    count -= 1
                    itemView.countTextView.text = count.toString() +"x"
                } else {
                    itemView.bottomLinearLayout.visibility = View.GONE
                    itemView.countTextView.visibility = View.GONE
                }
            }
            itemView.plusButton.setOnClickListener {
                count+=1
                itemView.countTextView.text = count.toString() +"x"
            }
        }
    }
    }