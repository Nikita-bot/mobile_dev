package ru.pazderin.retrofitforecaster.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import ru.pazderin.retrofitforecaster.R
import ru.pazderin.retrofitforecaster.classes.Main

import ru.pazderin.retrofitforecaster.classes.MyWeatherList

class Adapter(val list:List<MyWeatherList>): ListAdapter<MyWeatherList, RecyclerView.ViewHolder>(WeatherDiffCalback())
{
    val ITEM_HOT = 0
    val ITEM_COLD = 1

    class ColdViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val date = itemView.findViewById<TextView>(R.id.date)
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val coldText = itemView.findViewById<TextView>(R.id.cold)

    }

    class HotViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val date = itemView.findViewById<TextView>(R.id.date)
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val hotText = itemView.findViewById<TextView>(R.id.hot)
    }

    override fun getItemViewType(position: Int): Int {
        val main = Gson().fromJson(list[position].main, Main::class.java)
        if(main.temp!! > 0){
            return ITEM_HOT
        }
        else{
            return ITEM_COLD
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var itemView : View
        if(viewType==ITEM_COLD){
                itemView = LayoutInflater.from(parent.context).inflate(R.layout.r_view,parent,false)
                return ColdViewHolder(itemView)
        }
        else{
                itemView = LayoutInflater.from(parent.context).inflate(R.layout.r_hot_view,parent,false)
                return HotViewHolder(itemView)
        }
    }

//
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        val main = Gson().fromJson(list[position].main, Main::class.java)

        if(getItemViewType(position)==ITEM_COLD){
            holder as ColdViewHolder
            holder.date.text = list[position].dt_txt.toString()
            holder.coldText.text = main.temp.toString()
            holder.icon.setImageResource(R.drawable.snowsvg)
        }
        else{
            holder as HotViewHolder
            holder.date.text = list[position].dt_txt.toString()
            holder.hotText.text = main.temp.toString()
            holder.icon.setImageResource(R.drawable.sunsvg)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}