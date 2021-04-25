package com.example.proyectofinal_pablomarcos

import android.graphics.PostProcessor
import com.example.proyectofinal_pablomarcos.MusicModel
import okhttp3.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @get:GET("musica")
    val musica : Call<List<MusicModel?>?>?

    companion object {
        const val BASE_URL = "http://localhost:3000"
    }
}