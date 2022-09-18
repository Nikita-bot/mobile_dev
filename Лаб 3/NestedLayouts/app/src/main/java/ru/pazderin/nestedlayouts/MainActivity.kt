package ru.pazderin.nestedlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<ConstraintLayout>(R.id.vConstrain)


        val display:Display = windowManager.defaultDisplay

        view.layoutParams.height = display.height - 700




        val button: Button = findViewById<Button>(R.id.bChangeNubber)

        val tvt1 : TextView = findViewById(R.id.tvt1)
        val tvt2 : TextView = findViewById(R.id.tvt2)
        var tvt3 : TextView = findViewById(R.id.tvt3)

        val tvc1 : TextView = findViewById(R.id.tvc1)
        val tvc2 : TextView = findViewById(R.id.tvc2)
        val tvc3 : TextView = findViewById(R.id.tvc3)

        val tvb1 : TextView = findViewById(R.id.tvb1)
        val tvb2 : TextView = findViewById(R.id.tvb2)
        val tvb3 : TextView = findViewById(R.id.tvb3)

        val tvts = listOf<TextView>(tvt1,tvt2,tvt3)
        val tvcs = listOf<TextView>(tvc1,tvc2,tvc3)
        val tvbs = listOf<TextView>(tvb1,tvb2,tvb3)

        var index = 0
        var value = 1

        button.setOnClickListener {
            Log.v("view height",display.height.toString())
            index += 1
            value += 1
            if(index == 3) index = 0

            if(index == 0){
                tvts[index].text = value.toString()
                tvts[tvts.size - 1].text = ""

                tvcs[index].text = value.toString()
                tvcs[tvcs.size - 1].text = ""

                tvbs[index].text = value.toString()
                tvbs[tvbs.size - 1].text = ""

            }
            else{
                tvts[index].text = value.toString()
                tvts[index-1].text = ""

                tvcs[index].text = value.toString()
                tvcs[index-1].text = ""

                tvbs[index].text = value.toString()
                tvbs[index-1].text = ""
            }


        }
    }
}