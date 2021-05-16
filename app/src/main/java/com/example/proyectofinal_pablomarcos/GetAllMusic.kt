package com.example.proyectofinal_pablomarcos

import android.util.Log
import com.cbellmont.ejemplodescargainternet.MusicModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class GetAllMusic {

    companion object {

        fun send(mainActivityMain2Binding: MainActivity2) {

            val client = OkHttpClient()
            val url = "http://localhost:3000/musica/"
            val request = Request.Builder()
                .url(url)
                .build()
            val call = client.newCall(request)
            call.enqueue(object : Callback {

                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                    Log.e("GetAllMusic", call.toString())

                }

                override fun onResponse(call: Call, response: Response) {
                    CoroutineScope(Dispatchers.IO).launch {
                        val bodyInString = response.body?.string()
                        bodyInString?.let {
                            Log.w("GetAllMusic", bodyInString)
                            val JsonObject = JSONObject(bodyInString)

                            val results = JsonObject.optJSONArray("results")
                            results?.let {
                                Log.w("GetAllMusic", results.toString())
                                val gson = Gson()

                                val itemType = object : TypeToken<List<MusicModel>>() {}.type

                                val list =
                                    gson.fromJson<List<MusicModel>>(results.toString(), itemType)

                                mainActivityMain2Binding?.setAdapterOnMainThread(list)
                            }
                        }
                    }
                }
            })
        }
    }

}