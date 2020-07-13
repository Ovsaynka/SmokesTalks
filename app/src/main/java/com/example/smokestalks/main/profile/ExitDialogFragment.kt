package com.example.smokestalks.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.smokestalks.R
import kotlinx.android.synthetic.main.dialog_fragment.*

class ExitDialogFragment : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            exitButton.setOnClickListener {
                activity?.finish()
            }


        cancelButton.setOnClickListener {
            dismiss()
        }
    }
}