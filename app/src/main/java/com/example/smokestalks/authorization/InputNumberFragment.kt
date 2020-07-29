package com.example.smokestalks.authorization

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smokestalks.R
import com.example.smokestalks.SendID.SEND_ID
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import kotlinx.android.synthetic.main.actionbar.view.*
import kotlinx.android.synthetic.main.input_number_fragment.*
import java.util.concurrent.TimeUnit


class InputNumberFragment : Fragment() {

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
        val textShader: Shader = LinearGradient(
            0f, 0f, width, errorTextView.textSize, intArrayOf(
                Color.parseColor("#F46B45"),
                Color.parseColor("#EEA849")
            ), null, Shader.TileMode.REPEAT
        )
        errorTextView.paint.shader = textShader

        loginButton.setOnClickListener {
            val phoneNumber = numberEditText.text
            if (phoneNumber?.length!! < 13)
                errorTextView.text = "Недействительный формат номера"
            else {
                sendVerificationCode(phoneNumber.toString())
            }
        }
    }


    private fun sendVerificationCode(phoneNumber: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber,
            60,
            TimeUnit.SECONDS,
            requireActivity(),
            mCall
        )
    }

    private val mCall: OnVerificationStateChangedCallbacks =
        object : OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {

            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(
                    context, "Something went wrong, try again later please",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onCodeSent(
                verificationId: String,
                token: ForceResendingToken
            ) {
                Log.e("MainActivity", "Verification id : $verificationId")
                findNavController().navigate(
                    R.id.action_inputNumberFragment_to_inputCodeFragment,
                    bundleOf(SEND_ID to verificationId)
                )
            }
        }

}