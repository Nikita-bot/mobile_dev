package ru.pazderin.retrofitforecaster.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.pazderin.retrofitforecaster.classes.MyWeatherList

class WeatherDiffCalback : DiffUtil.ItemCallback<MyWeatherList>() {
    override fun areItemsTheSame(oldItem: MyWeatherList, newItem:MyWeatherList): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem:MyWeatherList, newItem:MyWeatherList): Boolean {
        return oldItem == newItem
    }
}