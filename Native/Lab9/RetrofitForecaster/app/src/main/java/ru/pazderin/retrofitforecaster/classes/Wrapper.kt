package ru.pazderin.retrofitforecaster.classes

import com.google.gson.JsonObject

data class Wrapper (
    var lot:Double,
    var lon:Double,
    var timezone:String,
    var timezone_offset:Int,
    var daily:JsonObject
)