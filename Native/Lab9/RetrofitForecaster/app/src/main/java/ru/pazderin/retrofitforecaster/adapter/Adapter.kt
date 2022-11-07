package ru.pazderin.mydialer


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import ru.pazderin.retrofitforecaster.R
import ru.pazderin.retrofitforecaster.adapter.WeatherDiffCalback
import ru.pazderin.retrofitforecaster.classes.Main

import ru.pazderin.retrofitforecaster.classes.MyWeatherList
import ru.pazderin.retrofitforecaster.classes.Wrapper

class Adapter(val list:List<MyWeatherList>): ListAdapter<MyWeatherList,Adapter.MyViewHolder>(WeatherDiffCalback())
{
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val date = itemView.findViewById<TextView>(R.id.date)
        val icon = itemView.findViewById<TextView>(R.id.icon)
        val hotText = itemView.findViewById<TextView>(R.id.hot)
        val coldText = itemView.findViewById<TextView>(R.id.cold)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.r_view,parent,false)
        return  MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.date.text = list[position].dtTxt
        val main = Gson().fromJson(list[position].main, Main::class.java)
        holder.coldText.text = main.temp.toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }
}