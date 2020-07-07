package com.example.smokestalks.main.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smokestalks.R
import com.example.smokestalks.data.Dish
import kotlinx.android.synthetic.main.menu_fragment.*

class MenuFragment: Fragment(), DishAdapter.Listener {

    private val dishesList = listOf(
        Dish("Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish("Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish("Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish("Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish("Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish("Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish("Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish("Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish("Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subcategoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = SubcategoriesAdapter()
        }

        categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CategoriesAdapter()
        }

        dishesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DishAdapter(dishesList)
        }
    }

    override fun onItemClick(dish: Dish) {

    }
}