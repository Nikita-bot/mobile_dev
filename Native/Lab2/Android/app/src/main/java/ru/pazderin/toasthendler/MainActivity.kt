package ru.pazderin.toasthendler

import android.os.Bundle
import android.widget.Button

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main);

        val button:Button = findViewById(R.id.button_ok)

        button.setOnClickListener {
            Toast.makeText(this, "Кнопка ОК", Toast.LENGTH_SHORT).show()
        }


    }
}