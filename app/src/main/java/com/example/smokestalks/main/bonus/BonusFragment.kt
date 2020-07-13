package com.example.smokestalks.main.bonus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.smokestalks.R

class BonusFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bonuses_frgment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}