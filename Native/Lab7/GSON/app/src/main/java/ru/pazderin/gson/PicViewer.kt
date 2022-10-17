package ru.pazderin.gson

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

class PicViewer() : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pic_viewer)


        var picLink = intent.extras?.get("picLink").toString()

        val picView: ImageView = findViewById(R.id.picView)
        Glide.with(this).load(picLink).into(picView)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        item.setIcon(ContextCompat.getDrawable(this,R.drawable.ic_favorite))
        val newIntent:Intent = Intent()
        newIntent.putExtra("link",intent.extras?.get("picLink").toString())
        newIntent.putExtra("info","Фотография добавлена в избранное")
        setResult(RESULT_OK,newIntent)
        finish()
        return super.onOptionsItemSelected(item)
    }

}