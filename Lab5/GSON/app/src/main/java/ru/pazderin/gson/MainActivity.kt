package ru.pazderin.gson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONArray
import org.json.JSONObject
import timber.log.Timber
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Timber.plant(Timber.DebugTree())

        val url = URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")
        var connection = url.openConnection() as HttpURLConnection
        var data = connection.inputStream.bufferedReader().toString()
    }
}

data class Photo(var id:String,
                 var owner:String,
                 var secret:String,
                 var server:String,
                 var farm:Int,
                 var title:String,
                 var ispublic:Boolean,
                 var isfriend:Boolean,
                 var isfamily:Boolean
                    )

data class PhotoPage(var page:Int,
                     var pages:Int,
                     var perpage:Int,
                     var total:Int,
                     var photo:JSONArray)

data class Wrapper(var photos:JSONObject,
                   var stat:String)