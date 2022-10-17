package ru.pazderin.gson

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(private val link: List<String>, val context: Context , val cellClickListener:CellClickListener): RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val firstImage : ImageView = itemView.findViewById(R.id.firstPhoto)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rview_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Glide.with(context).load(link[position]).into(holder.firstImage)
        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickListener(link[position])
        }
    }

    override fun getItemCount(): Int {
        return link.size
    }
}