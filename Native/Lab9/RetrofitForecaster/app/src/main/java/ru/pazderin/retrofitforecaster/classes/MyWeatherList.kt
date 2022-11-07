package ru.pazderin.retrofitforecaster.classes

import com.google.gson.JsonArray
import com.google.gson.JsonObject


data class MyWeatherList (
    var dt         : Int?,
    var main       : JsonObject,
    var weather    : JsonArray,
    var clouds     : JsonObject,
    var wind       : JsonObject,
    var visibility : Int?,
    var pop        : Double?,
    var rain       : JsonObject,
    var sys        : JsonObject,
    var dtTxt      : String?

)