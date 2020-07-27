package com.example.smokestalks.main.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smokestalks.R
import com.example.smokestalks.data.Dish

class DishAdapter(private val dishesList: List<Dish>):  RecyclerView.Adapter<DishViewHolder>() {

    private var listener: Listener? = null
    private var orderedList: List<Dish> = listOf()

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(dishesList[position])
    }

    interface Listener {
        fun onButtonClick(view: View)

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


    /*fun makeOrder(view: View){
        val resultList: ArrayList<Dish> = arrayListOf()
            for(dish in dishesList){
                if ()
                    resultList.add(dish)
            }

    }*/
}
