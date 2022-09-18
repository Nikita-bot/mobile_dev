package ru.pazderin.complexevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edText = findViewById<EditText>(R.id.etText)
        val bSave = findViewById<Button>(R.id.bSave)
        val cbCheck = findViewById<CheckBox>(R.id.cbCheck)
        val tvSavedText = findViewById<TextView>(R.id.tvSavedText)
        val progress = findViewById<ProgressBar>(R.id.pbProgress)


        bSave.setOnClickListener {
            if(cbCheck.isChecked){
                tvSavedText.text = " "
                tvSavedText.text = edText.text.toString()
                progress.progress += 10
            }
        }
    }
}