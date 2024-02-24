package com.example.mexstylemx.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mexstylemx.MainActivity
import com.example.mexstylemx.R
import com.example.mexstylemx.ui.paymentsuccess.PaymentSuccessActivity

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)


        val btnPayment: Button = findViewById(R.id.btnPayment)
        btnPayment.setOnClickListener {
            val intent = Intent(this, PaymentSuccessActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}