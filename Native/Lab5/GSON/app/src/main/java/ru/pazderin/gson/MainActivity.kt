package ru.pazderin.gson

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import ru.pazderin.gson.classes.*
import okhttp3.*
import ru.pazderin.gson.classes.Photo

import timber.log.Timber
import java.net.HttpURLConnection
import java.net.URL



interface CellClickListener{
    fun onCellClickListener(data:String)
}


class MainActivity : AppCompatActivity(),CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        var data = "{}"

        val t : Thread = Thread({
            val url = URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")
            val connection = url.openConnection() as HttpURLConnection
            data = connection.inputStream.bufferedReader().readText()
        })
        t.start()
        t.join()

        val wrapper:Wrapper = Gson().fromJson(data,Wrapper::class.java)
        val pp:PhotoPage = Gson().fromJson(wrapper.photos,PhotoPage::class.java)
        val photos = Gson().fromJson(pp.photo,Array<Photo>::class.java).toList()

        for(i in 0..(photos.size-1)){
            if (i%5==0){
                Timber.d(photos[i].toString())
            }
        }

        var liks = emptyList<String>()

        for (i in 0..(photos.size-1)){
            liks += "https://farm${photos[i].farm}.staticflickr.com/${photos[i].server}/${photos[i].id}_${photos[i].secret}_z.jpg"
        }

        val rView = findViewById<RecyclerView>(R.id.rView)

        rView.layoutManager = GridLayoutManager(this,2)
        rView.adapter = MyAdapter(liks,this,this)
    }

    override fun onCellClickListener(data: String) {
        Log.i("CellClick",data)

        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copyed text", data)
        clipboard.setPrimaryClip(clip)
    }
}






