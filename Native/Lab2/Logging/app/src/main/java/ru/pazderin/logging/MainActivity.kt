package ru.pazderin.logging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_log:Button = findViewById(R.id.button_log)

        val text:EditText = findViewById(R.id.text)

        button_log.setOnClickListener {
            Log.v("From EditText",text.getText().toString())
        }

        val button_timber:Button = findViewById(R.id.button_timber)
        Timber.plant(Timber.DebugTree())
        button_timber.setOnClickListener {
            Timber.v(text.getText().toString())
        }
    }
}