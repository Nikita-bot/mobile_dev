package ru.pazderin.attributes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text:EditText = findViewById(R.id.editText)

        val blackText:Button = findViewById(R.id.bBlackText)
        blackText.setOnClickListener {
            text.setTextColor(Color.BLACK)
        }
        val redText:Button = findViewById(R.id.bRedText)
        redText.setOnClickListener {
            text.setTextColor(Color.RED)
        }
        val size8:Button = findViewById(R.id.bSize8)
        size8.setOnClickListener {
            text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8f)
        }
        val size24:Button = findViewById(R.id.bSize24)
        size24.setOnClickListener {
            text.setTextSize(TypedValue.COMPLEX_UNIT_SP,24f)
        }
        val backYellow:Button = findViewById(R.id.bBackgroundYellow)
        backYellow.setOnClickListener {
            text.setBackgroundColor(Color.YELLOW)
        }
        val backWhite:Button = findViewById(R.id.bBackgroundWhite)
        backWhite.setOnClickListener {
            text.setBackgroundColor(Color.WHITE)
        }

    }
}