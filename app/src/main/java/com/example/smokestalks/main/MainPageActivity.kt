package com.example.smokestalks.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.smokestalks.R
import com.example.smokestalks.data.Dish
import com.example.smokestalks.main.bonus.BonusFragment
import com.example.smokestalks.main.menu.MenuFragment
import com.example.smokestalks.main.news.NewsFragment
import com.example.smokestalks.main.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.dish_item.*
import kotlinx.android.synthetic.main.menu_navigation_button.*

class MainPageActivity: AppCompatActivity(),
    FragmentsRouters, Visibility {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_navigation_button)

        setSupportActionBar(titleToolbar)

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigationView.itemBackground
        val fragment = MenuFragment()
        addFragment(fragment)
    }
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_menu -> {
                    val fragment =
                        MenuFragment()
                    titleTextView.text = "Меню"
                    titleToolbar.visibility = View.VISIBLE
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_news -> {
                    val fragment =
                        NewsFragment()
                    titleTextView.text = "Новости"
                    titleToolbar.visibility = View.VISIBLE
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_bonus -> {
                    val fragment = BonusFragment()
                    titleTextView.text = "Бонусы"
                    titleToolbar.visibility = View.VISIBLE
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_account -> {
                    val fragment = ProfileFragment()
                    titleTextView.text = "Профиль"
                    titleToolbar.visibility = View.VISIBLE
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.fragment_fade_enter,
                R.anim.fragment_close_exit
            )
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun navigateToFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun hideView() {
        val toolbar = titleToolbar
        toolbar.visibility = View.GONE
    }

    override fun showView() {
        val show = orderField
        show.visibility = View.VISIBLE
    }
}