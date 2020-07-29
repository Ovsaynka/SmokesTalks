package com.example.smokestalks.authorization

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smokestalks.R
import com.example.smokestalks.SendID
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.actionbar.view.*
import kotlinx.android.synthetic.main.input_code_fragment.*
import java.util.*


class InputCodeFragment : Fragment() {

    lateinit var mAuth: FirebaseAuth
    private val mVerificationId = arguments?.getString(SendID.SEND_ID)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_code_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mAuth = FirebaseAuth.getInstance()
        mAuth.setLanguageCode(Locale.getDefault().language)


        include.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_inputCodeFragment_to_inputNumberFragment)
        }
        val paint = codeErrorTextView.paint
        val width = paint.measureText(codeErrorTextView.text.toString())
        val textShader: Shader = LinearGradient(
            0f, 0f, width, codeErrorTextView.textSize, intArrayOf(
                Color.parseColor("#F46B45"),
                Color.parseColor("#EEA849")
            ), null, Shader.TileMode.REPEAT
        )
        codeErrorTextView.paint.shader = textShader

        inputCodeView.addOnCompleteListener { code ->
            Toast.makeText(context, inputCodeView.code, Toast.LENGTH_SHORT).show()
            if (code.isEmpty() || code.length < 6) {
                codeErrorTextView.text = "Неверный код"
                inputCodeView.setEditable(true)
            }
            verifyVerificationCode(code.toString())
            findNavController().navigate(R.id.action_inputCodeFragment_to_inputPersonalDataFragment)
        }
    }

    private fun verifyVerificationCode(code: String) {
        val credential = mVerificationId?.let { PhoneAuthProvider.getCredential(it, code) }

        credential?.let { signInWithPhoneAuthCredential(it) }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user: FirebaseUser = task.result?.user!!
                    findNavController().navigate(R.id.action_inputCodeFragment_to_inputPersonalDataFragment)
                } else {
                    var message =
                        "Verification failed , Please try again later."
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        message = "Invalid code entered..."
                    }
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                }
            }
    }
}
