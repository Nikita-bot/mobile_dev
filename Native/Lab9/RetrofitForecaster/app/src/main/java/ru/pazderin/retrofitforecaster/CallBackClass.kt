package ru.pazderin.retrofitforecaster


import android.util.Log
import retrofit2.Callback
import retrofit2.Response
import ru.pazderin.retrofitforecaster.classes.Wrapper

import com.google.gson.Gson
import retrofit2.Call

import ru.pazderin.retrofitforecaster.classes.Main
import ru.pazderin.retrofitforecaster.classes.MyWeatherList

class CallBackClass:Callback<Wrapper> {
    override fun onResponse(call: Call<Wrapper>, response: Response<Wrapper>) {

        if(response.isSuccessful){
            val wrapper: Wrapper? = response.body()
            val myList= Gson().fromJson(wrapper?.list,Array<MyWeatherList>::class.java).toList()
            val main:Main = Gson().fromJson(myList[1].main,Main::class.java)
            Log.v("Time",myList[1].dtTxt.toString())
            Log.v("Temp",main.temp.toString())
        }
    }

    override fun onFailure(call: Call<Wrapper>, t: Throwable) {
        Log.e("Error",t.toString())
    }

}