package com.example.paymentsapp

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_create.*

class create : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val upi_editText= findViewById<EditText>(R.id.editText)
        val upi_string = upi_editText.text.toString()

        if (upi_editText.text != null ){
            create_upi_buttton.setOnClickListener {
                creatQRcode(upi_string)

            }
        }else
        {
            create_upi_buttton.setOnClickListener {
                creatQRcode("example@oksbi")
            }
        }

    }

    private fun creatQRcode(upiString: String?) {

        val value = upiString
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(value, BarcodeFormat.QR_CODE,512,512)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bitmap = Bitmap.createBitmap(width , height , Bitmap.Config.RGB_565)
        for ( x in 0 until width ){
            for ( y in 0 until height ){
                bitmap.setPixel(x,y,if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
            }
        }
        imageView.setImageBitmap(bitmap)
    }


}
