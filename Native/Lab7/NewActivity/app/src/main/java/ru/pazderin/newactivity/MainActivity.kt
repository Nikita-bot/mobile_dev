package ru.pazderin.newactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_show_pic : Button = findViewById(R.id.btn_show_pic)

        btn_show_pic.setOnClickListener {
            val intent:Intent = Intent(this,PicActivity::class.java)
            intent.putExtra("picLink","https://domfotooboev.com.ua/home/products_images/10093.jpg")
            startActivity(intent)
        }
    }
}