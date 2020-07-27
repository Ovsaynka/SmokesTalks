package com.example.smokestalks.main.menu.order

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.smokestalks.QRCodeActivity
import com.example.smokestalks.R
import com.example.smokestalks.main.Visibility
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.code_scanner.*
import kotlinx.android.synthetic.main.order_fragment.*


class OrderFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.order_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val hide = activity as? Visibility
        hide?.hideView()
        createOrderButton.setOnClickListener {
            startActivity(Intent(context,QRCodeActivity::class.java))
            //startQRScanner()
        }
    }


    /*private fun startQRScanner() {
        IntentIntegrator(QRCodeActivity()).initiateScan()
    }*/
}