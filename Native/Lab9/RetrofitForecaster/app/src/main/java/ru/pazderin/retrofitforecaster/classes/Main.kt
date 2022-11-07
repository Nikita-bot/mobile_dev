package ru.pazderin.retrofitforecaster.classes

data class Main (

    var temp      : Double?,
    var feelsLike : Double?,
    var tempMin   : Double?,
    var tempMax   : Double?,
    var pressure  : Int?,
    var seaLevel  : Int?,
    var grndLevel : Int?,
    var humidity  : Int?,
    var tempKf    : Double?

)