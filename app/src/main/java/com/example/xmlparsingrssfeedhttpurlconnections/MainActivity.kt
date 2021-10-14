package com.example.xmlparsingrssfeedhttpurlconnections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlparsingrssfeedhttpurlconnections.model.RSS
import com.example.xmlparsingrssfeedhttpurlconnections.model.channel.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RVNews
    lateinit var rvMain: RecyclerView
    val BASE_URL = "https://www.nytimes.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()

        val rssApi =retrofit.create(RSSAPI::class.java)
        val call = rssApi.feed

        call!!.enqueue(object : Callback<RSS?>{
            override fun onResponse(call: Call<RSS?>, response: Response<RSS?>) {
                var items = response.body()!!.channel!!.item
                adapter = RVNews(items as ArrayList<Item>)
                rvMain.adapter = adapter
                rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<RSS?>, t: Throwable) {
                Log.e("TAG", "$t")
            }

        })


    }
}