package com.example.smokestalks.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.smokestalks.R
import com.example.smokestalks.main.FragmentsRouters
import com.example.smokestalks.main.menu.order.OrderHistoryFragment
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val router = activity as? FragmentsRouters
        aboutProgramTextView.setOnClickListener {
            router?.navigateToFragment(AboutProgramFragment())
        }
        orderTextView.setOnClickListener {
            router?.navigateToFragment(OrderHistoryFragment())
        }

        editingTextView.setOnClickListener {
            router?.navigateToFragment(ProfileEditingFragment())
        }

        exitTextView.setOnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.addToBackStack(null)
            val dialogFragment = ExitDialogFragment()
            dialogFragment.show(fragmentTransaction, "dialog")
        }
    }
}