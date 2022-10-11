package ru.pazderin.mydialer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import ru.pazderin.mydialer.classes.Contact
import ru.pazderin.mydialer.classes.Wrapper
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = "{}"

        val t : Thread = Thread({
            val url = URL("https://drive.google.com/u/0/uc?id=1-KO-9GA3NzSgIc1dkAsNm8Dqw0fuPxcR&export=download")
            val connection = url.openConnection() as HttpURLConnection
            data = connection.inputStream.bufferedReader().readText()
        })
        t.start()
        t.join()

//        var wrapper = Gson().fromJson(data,Wrapper::class.java)
        var contacts = Gson().fromJson(data,Array<Contact>::class.java).toList()

        val rView = findViewById<RecyclerView>(R.id.rView)

        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = Adapter(contacts)

        val btn_search = findViewById<Button>(R.id.btn_search)
        val et_search = findViewById<EditText>(R.id.et_search)

        btn_search.setOnClickListener {
            var text = et_search.text
            var newList = emptyList<Contact>()
            for (i in contacts){
                if(i.name.contains(text,true)||i.type.contains(text,true)){
                    newList += i
                }
            }
            rView.adapter= Adapter(newList)

        }
    }
}