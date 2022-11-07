package ru.pazderin.retrofitforecaster.classes

import com.google.gson.JsonArray
import com.google.gson.JsonObject


data class Wrapper (
    var cod     : String?,
    var message : Int?,
    var cnt     : Int?,
    var list    : JsonArray,
    var city    : JsonObject,

)