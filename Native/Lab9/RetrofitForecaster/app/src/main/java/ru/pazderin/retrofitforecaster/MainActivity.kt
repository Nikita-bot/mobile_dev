package ru.pazderin.retrofitforecaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.pazderin.retrofitforecaster.API.OpenWeatherAPI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var API:OpenWeatherAPI = OpenWeatherAPI()
        API.getWeather()
    }
}