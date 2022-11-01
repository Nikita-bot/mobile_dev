package ru.pazderin.retrofitforecaster.API

import android.util.Log
import com.google.gson.Gson
import ru.pazderin.retrofitforecaster.classes.Wrapper
import java.net.HttpURLConnection
import java.net.URL

class OpenWeatherAPI {
    fun getWeather() {
        //https://api.openweathermap.org/data/3.0/onecall?lat=48.003670&lon=18.707250&exclude=current,minutely,hourly,alerts&appid=f4ecb913d35a18fee6ce37d714c9f85f
        var url:URL = URL("https://api.openweathermap.org/data/3.0/onecall?lat=48.003670&lon=18.707250&exclude=current,minutely,hourly,alerts&appid=f4ecb913d35a18fee6ce37d714c9f85f")
        var data = "{}"

        val t : Thread = Thread({
            var url:URL = URL("https://api.openweathermap.org/data/3.0/onecall?lat=48.003670&lon=18.707250&exclude=current,minutely,hourly,alerts&appid=f4ecb913d35a18fee6ce37d714c9f85f")
            val connection = url.openConnection() as HttpURLConnection
            data = connection.inputStream.bufferedReader().readText()
            println("In Thread")
        })
        t.start()
        t.join()
        println(data)
        val wrapper:Wrapper = Gson().fromJson(data,Wrapper::class.java)
        Log.v("Wrapper.timezone",wrapper.timezone)
    }
}