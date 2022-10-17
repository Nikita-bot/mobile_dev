package ru.pazderin.newactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

class PicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pic_layout)


        val picLink:String = intent.extras?.get("picLink").toString()

        val picView:ImageView = findViewById(R.id.picView)
        Glide.with(this).load(picLink).into(picView)

        Log.i("Image","Download Sucsess")
    }
}