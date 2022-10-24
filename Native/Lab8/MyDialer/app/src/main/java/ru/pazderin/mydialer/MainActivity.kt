package ru.pazderin.mydialer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import ru.pazderin.mydialer.classes.Contact
import ru.pazderin.mydialer.classes.Wrapper
import java.net.HttpURLConnection
import java.net.URL

interface CellClickListener{
    fun onCellClick(phone:String)
}


class MainActivity : AppCompatActivity() , CellClickListener {

    val APP_PREFERENCES = "app_preferences"
    val SEARCH_FILTER = "filter"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edView :EditText = findViewById(R.id.et_search)
        val rView = findViewById<RecyclerView>(R.id.rView)

        var data = "{}"

        val t : Thread = Thread({
            val url = URL("https://drive.google.com/u/0/uc?id=1-KO-9GA3NzSgIc1dkAsNm8Dqw0fuPxcR&export=download")
            val connection = url.openConnection() as HttpURLConnection
            data = connection.inputStream.bufferedReader().readText()
        })
        t.start()
        t.join()

//        var wrapper = Gson().fromJson(data,Wrapper::class.java)
        var allContacts =  Gson().fromJson(data,Array<Contact>::class.java).toList()
        var myContact = mutableListOf<Contact>()

        val mSettings:SharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        if(mSettings.contains(SEARCH_FILTER)){
            edView.setText(mSettings.getString(SEARCH_FILTER,""))
            for(i in allContacts){
                if (i.name.contains(edView.text,true)||i.type.contains(edView.text,true)){
                    myContact.add(i)
                }
            }
        }
        else myContact.addAll(allContacts)

        rView.layoutManager = LinearLayoutManager(this)
        val adapter:Adapter = Adapter(myContact,this)
        rView.adapter = adapter

        edView.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun afterTextChanged(p0: Editable?) {
                val editor:Editor = mSettings.edit()
                editor.putString(SEARCH_FILTER,edView.text.toString())
                editor.apply()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, end: Int, count: Int) {
                myContact.clear()
                for(i in allContacts){
                    if (i.name.contains(edView.text,true)||i.type.contains(edView.text,true)){
                        myContact.add(i)
                    }
                }
                adapter.notifyDataSetChanged()

            }
        })
    }

    override fun onCellClick(phone: String) {
        val i = Intent(Intent.ACTION_DIAL)
        i.data = Uri.parse("tel:" + "${phone}")
        startActivity(i)
    }
}