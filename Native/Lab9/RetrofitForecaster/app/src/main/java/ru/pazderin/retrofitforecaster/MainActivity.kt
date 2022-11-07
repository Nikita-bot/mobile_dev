package ru.pazderin.retrofitforecaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import ru.pazderin.retrofitforecaster.classes.Wrapper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.openweathermap.org/data/2.5/").build()
        var retrofitServise:RetrofitServise = retrofit.create(RetrofitServise::class.java)
        val result:Call<Wrapper> = retrofitServise.getWeather()
        result.enqueue(CallBackClass())

    }
}