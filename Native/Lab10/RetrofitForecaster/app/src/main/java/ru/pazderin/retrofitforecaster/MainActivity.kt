package ru.pazderin.retrofitforecaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pazderin.retrofitforecaster.adapter.Adapter
import ru.pazderin.retrofitforecaster.classes.MyWeatherList
import ru.pazderin.retrofitforecaster.classes.Wrapper

class MainActivity : AppCompatActivity() {

    lateinit var myList:ArrayList<MyWeatherList>
    val WEATHER_STATE:String = "WEATHER"

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putParcelableArrayList(WEATHER_STATE,myList as java.util.ArrayList<out Parcelable>)

        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rView = findViewById<RecyclerView>(R.id.rView)

        if(savedInstanceState!=null && savedInstanceState.containsKey(WEATHER_STATE)){
            myList= savedInstanceState.getParcelableArrayList<Parcelable>(WEATHER_STATE) as ArrayList<MyWeatherList>
        }
        else{
            val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.openweathermap.org/data/2.5/").build()
            val retrofitServise:RetrofitServise = retrofit.create(RetrofitServise::class.java)
            val result:Call<Wrapper> = retrofitServise.getWeather()
            rView.layoutManager = LinearLayoutManager(this)

            result.enqueue(object : Callback<Wrapper> {
                override fun onResponse(call: Call<Wrapper>, response: Response<Wrapper>) {
                    if(response.isSuccessful){
                        val wrapper: Wrapper? = response.body()
                        //Log.i("запрос",wrapper.toString())
                        myList = Gson().fromJson(wrapper?.list,Array<MyWeatherList>::class.java).toList() as ArrayList<MyWeatherList>
                        Log.v("Time",myList[1].dt_txt.toString())


                    }
                }
                override fun onFailure(call: Call<Wrapper>, t: Throwable) {
                    t.message?.let { Log.e("onFailure", it) }
                }

            })

            rView.adapter = Adapter(myList)

        }

    }
}