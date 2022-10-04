package ru.pazderin.gson.classes

import com.google.gson.JsonArray

data class PhotoPage(var page:Int = 1,
                     var pages:Int,
                     var perpage:Int,
                     var total:Int,
                     var photo: JsonArray
)