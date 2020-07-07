package com.example.smokestalks.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.smokestalks.main.menu.MenuFragment
import com.example.smokestalks.main.news.NewsFragment
import com.example.smokestalks.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.menu_navigation_button.*

class MainPageActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_navigation_button)

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
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_news -> {
                    val fragment =
                        NewsFragment()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                /*R.id.navigation_bonus -> {
                    val fragment = AddressFragment
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_account -> {
                    val fragment = AddressFragment.newInstance(restaurant)
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }*/
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.fragment_fade_enter,//fade_in_left,
                R.anim.fragment_close_exit
            )
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }

}