package com.example.smokestalks.authorization

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smokestalks.R
import kotlinx.android.synthetic.main.actionbar.view.*
import kotlinx.android.synthetic.main.input_number_fragment.*

class InputNumberFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_number_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        action_bar.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_inputNumberFragment_to_startPageFragment)
        }
        val paint = errorTextView.paint
        val width = paint.measureText(errorTextView.text.toString())
        val textShader: Shader = LinearGradient(0f, 0f, width, errorTextView.textSize, intArrayOf(
            Color.parseColor("#F46B45"),
            Color.parseColor("#EEA849")
        ), null, Shader.TileMode.REPEAT)
        errorTextView.paint.shader = textShader

        loginButton.setOnClickListener {
            if (numberEditText.length() < 17)
                errorTextView.text = "Недействительный формат номера"
            else {
                
                findNavController().navigate(R.id.action_inputNumberFragment_to_inputCodeFragment)
            }
        }
    }

}