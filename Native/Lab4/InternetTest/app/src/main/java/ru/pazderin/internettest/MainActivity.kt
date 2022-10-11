package ru.pazderin.internettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import okhttp3.*
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnHTTP)
        var data = ""

        val t : Thread = Thread({
            val url = URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")
            val connection = url.openConnection() as HttpURLConnection
            data = connection.inputStream.bufferedReader().readText()
        })
        t.start()
        t.join()
        btn.setOnClickListener {
            Log.d("Flickr cats",data)
        }

        val btn2 = findViewById<Button>(R.id.btnOkHTTP)
        var okData = ""

        val request:Request = Request.Builder().url("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1").build()
        val okHttpClient :OkHttpClient= OkHttpClient()
        okHttpClient.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                okData = response.body?.string().toString()
            }

        })
        btn2.setOnClickListener {
            Log.i("Flickr OkCats",okData)
        }
    }
}