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
import kotlinx.android.synthetic.main.input_code_fragment.*

class InputCodeFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_code_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        include.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_inputCodeFragment_to_inputNumberFragment)
        }
        val paint = codeErrorTextView.paint//textView.paint
        val width = paint.measureText(codeErrorTextView.text.toString())
        val textShader: Shader = LinearGradient(0f, 0f, width, codeErrorTextView.textSize, intArrayOf(
            Color.parseColor("#F46B45"),
            Color.parseColor("#EEA849")
        ), null, Shader.TileMode.REPEAT)
        codeErrorTextView.paint.shader = textShader
        inputCodeView.addOnCompleteListener { code ->
            //if(code?.length == 4)
            if (code != "1234") {
                codeErrorTextView.text = "Неверный код"
                inputCodeView.setEditable(true)
            } else
                findNavController().navigate(R.id.action_inputCodeFragment_to_inputPersonalDataFragment)
        }
    }
}
