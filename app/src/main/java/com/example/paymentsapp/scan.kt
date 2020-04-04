package com.example.paymentsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_scan.*

class Scan : AppCompatActivity() {
    private var butn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        upiTextView = findViewById(R.id.upi_text) as TextView
         butn = findViewById<Button>(R.id.btn)
        btn!!.setOnClickListener {
            val intent = Intent(this, Scanner::class.java)
            startActivity(intent)
        }
    }

    companion object {

        var upiTextView: TextView? = null
    }
}
