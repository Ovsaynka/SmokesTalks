package com.example.smokestalks

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.media.RingtoneManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.ResultPoint
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import kotlinx.android.synthetic.main.code_scanner.*
import java.util.*
import kotlin.concurrent.schedule


open class QRCodeActivity : AppCompatActivity() {

    var dbvScanner: DecoratedBarcodeView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.code_scanner)
        dbvScanner = findViewById<View>(R.id.scanBarcode) as DecoratedBarcodeView
        requestPermission()
        dbvScanner!!.decodeContinuous(object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult) {
                if (result.text == "Asedo") {
                    indicatorOrderImageView.setImageResource(R.drawable.order_ok)
                    Timer("SettingUp", false).schedule(300) {
                        finish()
                    }
                }else {
                    indicatorOrderImageView.setImageResource(R.drawable.order_failed)
                    orderErrorTextView.text = "Похоже, что-то пошло не так, пожалуйста, попробуй еще раз."
                    Timer("SettingUp", false).schedule(1500) {
                        finish()
                    }
                }
                beepSound()
            }

            override fun possibleResultPoints(resultPoints: List<ResultPoint>) {}
        })
    }


    fun beepSound() {
        try {
            val notification =
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val r = RingtoneManager.getRingtone(applicationContext, notification)
            r.play()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onResume() {
        super.onResume()
        resumeScanner()
    }

    private fun resumeScanner() {
        if (!dbvScanner!!.isActivated) dbvScanner!!.resume()
        Log.d("peeyush-pause", "paused: false")
    }

    protected fun pauseScanner() {
        dbvScanner!!.pause()
    }

    override fun onPause() {
        super.onPause()
        pauseScanner()
    }

    private fun requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                0
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isEmpty()) {
            requestPermission()
        } else {
            dbvScanner!!.resume()
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        val result =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                updateText(result.contents)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun updateText(scanCode: String) {
        orderErrorTextView.text = scanCode
    }
}