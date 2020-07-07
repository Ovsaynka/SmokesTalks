package com.example.smokestalks.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smokestalks.R
import kotlinx.android.synthetic.main.personal_data_fragment.*


class InputPersonalDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.personal_data_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val genderSpinner: Spinner = genderSpinner
        ArrayAdapter.createFromResource(
            view.context,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            genderSpinner.adapter = adapter
        }

        val citySpinner: Spinner = citySpinner
        ArrayAdapter.createFromResource(
            view.context,
            R.array.city_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            citySpinner.adapter = adapter
        }

        saveButton.setOnClickListener {
            findNavController().navigate(R.id.action_inputPersonalDataFragment_to_menuActivity)
        }

    }
}