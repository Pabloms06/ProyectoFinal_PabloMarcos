package com.example.proyectofinal_pablomarcos

import android.util.Log
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

        fun send(activity: MainActivity2) {

            val client = OkHttpClient()

            val url = "https://01b155cef126.ngrok.io/musica/"   //enlace generado con NGROK
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
                        var bodyInString = response.body?.string()
                        bodyInString = "{\"results\":$bodyInString}"

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

                                Log.w("Pablo",results.toString())
                                activity?.setAdapterOnMainThread(list as MutableList<MusicModel>)
                            }
                        }
                    }
                }
            })
        }
    }

}