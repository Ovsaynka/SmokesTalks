package com.example.smokestalks.main.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smokestalks.R
import com.example.smokestalks.data.Dish
import com.example.smokestalks.main.Visibility
import kotlinx.android.synthetic.main.dish_item.*
import kotlinx.android.synthetic.main.dish_item.view.*
import kotlinx.android.synthetic.main.menu_fragment.*
import kotlinx.android.synthetic.main.menu_navigation_button.*


class MenuFragment: Fragment(){//, DishAdapter.Listener {

    private val dishesList = listOf(
        Dish(1,"Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish(2,"Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish(3,"Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish(4,"Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish(5,"Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish(6,"Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish(7,"Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish(8,"Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750),
        Dish(9,"Помидоры гриль","Из груши, яблок, винограда, киви, апельсина",155,750)
    )
    private var count =1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    @SuppressLint("SetTextI18n")
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
            addItemDecoration(
                DividerItemDecoration(
                    view.context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
    }

 /*   override fun onButtonClick(view: View) {
        view.dishItem.addButton.setOnClickListener {
            val show = activity as? Visibility
            show?.showView()
        }
    }*/

}