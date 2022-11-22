package ru.pazderin.retrofitforecaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import ru.pazderin.retrofitforecaster.classes.Main
import ru.pazderin.retrofitforecaster.classes.MyWeatherList
import ru.pazderin.retrofitforecaster.classes.Wrapper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.openweathermap.org/data/2.5/").build()
        val retrofitServise:RetrofitServise = retrofit.create(RetrofitServise::class.java)
        val result:Call<Wrapper> = retrofitServise.getWeather()
        var myList:List<MyWeatherList>
        val rView = findViewById<RecyclerView>(R.id.rView)
        rView.layoutManager = LinearLayoutManager(this)

        result.enqueue(object : Callback<Wrapper> {
            override fun onResponse(call: Call<Wrapper>, response: Response<Wrapper>) {
                if(response.isSuccessful){
                    val wrapper: Wrapper? = response.body()
                    myList = Gson().fromJson(wrapper?.list,Array<MyWeatherList>::class.java).toList()
                    Log.v("Time",myList[1].dt_txt.toString())
                    rView.adapter = Adapter(myList)

                }
            }

            override fun onFailure(call: Call<Wrapper>, t: Throwable) {
                t.message?.let { Log.e("onFailure", it) }
            }

        })
    }
}