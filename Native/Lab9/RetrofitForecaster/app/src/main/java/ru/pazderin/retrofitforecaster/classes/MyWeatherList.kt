package ru.pazderin.retrofitforecaster.classes

import com.google.gson.JsonArray
import com.google.gson.JsonObject


data class MyWeatherList (
    var main       : JsonObject,
    var dt_txt      : String?

)