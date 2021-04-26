package com.example.proyectofinal_pablomarcos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buscar.setOnClickListener{
            val text = texto.text
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(MainActivity2.PARAM1, text.toString())
            startActivity(intent)
        }

        var rf = Retrofit.Builder()
            .baseUrl(RetrofitInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        var API = rf.create(RetrofitInterface::class.java)
        var call = API.musica

        call?.enqueue(object:Callback<List<MusicModel?>?>{
            override fun onResponse(
                call: Call<List<MusicModel?>?>?,
                response: Response<List<MusicModel?>?>?
            ) {
                var postlist : List<MusicModel>? = response?.body() as List<MusicModel>
                var post = arrayOfNulls<String>(postlist.size)

                for (i in postlist.indices)
                    post[i] = postlist[i].icon.transitionName

            }

            override fun onFailure(call: Call<List<MusicModel?>?>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }
}