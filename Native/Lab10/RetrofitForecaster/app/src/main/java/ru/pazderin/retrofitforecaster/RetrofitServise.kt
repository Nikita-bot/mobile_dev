package ru.pazderin.retrofitforecaster

import retrofit2.Call
import retrofit2.http.*
import ru.pazderin.retrofitforecaster.classes.MyWeatherList
import ru.pazderin.retrofitforecaster.classes.Wrapper

interface RetrofitServise {
//    @GET("forecast?lat=54.219041&lon=30.277746&appid=f4ecb913d35a18fee6ce37d714c9f85f&units=metric")
//    fun getWeather() : Call<Wrapper>
//Kemerovo
    @GET("forecast?lat=55.345024&lon=86.062302&appid=f4ecb913d35a18fee6ce37d714c9f85f&units=metric")
    fun getWeather() : Call<Wrapper>
}