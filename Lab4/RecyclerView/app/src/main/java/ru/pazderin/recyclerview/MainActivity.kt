package ru.pazderin.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



interface CellClickListener{
    fun onCellClickListener(data:ColorData)
}

class MainActivity : AppCompatActivity() ,CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MyAdapter(fetchColors(),this)
    }
    fun fetchColors():List<ColorData>{
        val colors = listOf<ColorData>(
            ColorData("Yellow", Color.YELLOW),
            ColorData("White", Color.WHITE),
            ColorData("Red", Color.RED),
            ColorData("Green", Color.GREEN),
            ColorData("Black", Color.BLACK),
            ColorData("Blue", Color.BLUE))
        return colors
    }

    override fun onCellClickListener(data: ColorData) {
        Toast.makeText(this,"IT's ${data.colorName}", Toast.LENGTH_SHORT).show()
    }
}

class ColorData(
    val colorName:String,
    val colorHex:Int
)

class MyAdapter(private val colors: List<ColorData>,
                private val cellClickListener: CellClickListener):RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val rv_View :View = itemView.findViewById(R.id.rv_View)
        val rv_TextView :TextView = itemView.findViewById(R.id.rv_TextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rview_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.rv_View.setBackgroundColor(colors[position].colorHex)
        holder.rv_TextView.text = colors[position].colorName
        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickListener(colors[position])
        }
    }

    override fun getItemCount(): Int {
        return colors.size
    }
}