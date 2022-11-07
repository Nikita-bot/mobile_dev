package ru.pazderin.retrofitforecaster.classes

import com.google.gson.JsonObject

data class City (
    var id         : Int?,
    var name       : String?,
    var coord      : JsonObject,
    var country    : String?,
    var population : Int?,
    var timezone   : Int?,
    var sunrise    : Int?,
    var sunset     : Int?
)