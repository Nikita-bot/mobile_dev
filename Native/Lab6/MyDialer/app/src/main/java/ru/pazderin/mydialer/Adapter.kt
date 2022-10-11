package ru.pazderin.mydialer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.pazderin.mydialer.classes.Contact

class Adapter(val list:List<Contact>): RecyclerView.Adapter<Adapter.MyViewHolder>()
{
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val textName = itemView.findViewById<TextView>(R.id.textName)
        val textPhone = itemView.findViewById<TextView>(R.id.textPhone)
        val textType = itemView.findViewById<TextView>(R.id.textType)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rview_item,parent,false)
        return  MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textName.text = list[position].name
        holder.textPhone.text = list[position].phone
        holder.textType.text = list[position].type

    }

    override fun getItemCount(): Int {
        return list.size
    }
}