package ru.pazderin.retrofitforecaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pazderin.retrofitforecaster.adapter.Adapter
import ru.pazderin.retrofitforecaster.classes.MyWeatherList
import ru.pazderin.retrofitforecaster.classes.WeatherStore
import ru.pazderin.retrofitforecaster.classes.Wrapper

class MainActivity : AppCompatActivity() {

    var responseJson:Wrapper? = null
    val WEATHER_STATE:String = "WEATHER"


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var savedInstance = Gson().toJson(responseJson)
        outState.putString(WEATHER_STATE,savedInstance)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rView = findViewById<RecyclerView>(R.id.rView)
        rView.layoutManager = LinearLayoutManager(this)

        if(WeatherStore.weathers.isNotEmpty()){
//
//            responseJson = Gson().fromJson(savedInstanceState.getString(WEATHER_STATE),Wrapper::class.java)
//            Log.i("SavedInstanceState", savedInstanceState.toString())
            Log.i("Из объекта", WeatherStore.weathers.toString())
            rView.adapter = Adapter(WeatherStore.weathers)
        }
        else{
            val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.openweathermap.org/data/2.5/").build()
            val retrofitServise:RetrofitServise = retrofit.create(RetrofitServise::class.java)
            val result:Call<Wrapper> = retrofitServise.getWeather()

            result.enqueue(object : Callback<Wrapper> {
                override fun onResponse(call: Call<Wrapper>, response: Response<Wrapper>) {
                    if(response.isSuccessful){
                        responseJson = response.body()
                        Log.i("запрос",responseJson.toString())
                        WeatherStore.weathers = Gson().fromJson(responseJson?.list,Array<MyWeatherList>::class.java).toList()

                        rView.adapter = Adapter(WeatherStore.weathers)
                    }
                }
                override fun onFailure(call: Call<Wrapper>, t: Throwable) {
                    t.message?.let { Log.e("onFailure", it) }
                }
            })

        }
    }
}