package ru.pazderin.retrofitforecaster.classes

import com.google.gson.JsonObject

data class Daily (
   var dt:Int,
   var sunrise: Int,
   var sunset :Int,
   var moonrise: Int,
   var moonset: Int,
   var moon_phase: Double,
   var temp: JsonObject,
   var feels_like: JsonObject,
   var pressure: Int,
   var humidity: Int,
   var dew_point: Double,
   var wind_speed: Double,
   var wind_deg: Int,
   var wind_gust: Double,
   var weather: JsonObject,
   var clouds: Int,
   var pop: Double,
   var rain: Double,
   var uvi: Double
)
