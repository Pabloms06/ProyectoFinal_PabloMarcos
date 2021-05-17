package com.example.proyectofinal_pablomarcos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.get

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cbellmont.ejemplodescargainternet.MusicModel
import com.example.proyectofinal_pablomarcos.databinding.ActivityMain2Binding
import kotlinx.android.synthetic.main.activity_main_2.*
import kotlinx.android.synthetic.main.music_layout.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity2 : AppCompatActivity() {
    private var adapter: MusicAdapter = MusicAdapter()
    private lateinit var model: MainActivityViewModel
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        recibirdatos()

        GetAllMusic.send(this)
        recibirdatos()

        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        descargartodas()
        createRecyclerView()

    }

    private fun recibirdatos() {
        val intent: Intent = intent
        var selecciondecada = intent.getStringExtra("decada")
        var selecciongenero = intent.getStringExtra("genero")

    }

    private fun createRecyclerView() {
        binding.vista.layoutManager = LinearLayoutManager(this)
        binding.vista.adapter = adapter
    }

    private fun descargartodas() {
        lifecycleScope.launch {
            val list = DESCARGARTODAS()
            setAdapterOnMainThread(list)
        }
    }

    private suspend fun DESCARGARTODAS(): MutableList<MusicModel> {
        return withContext(Dispatchers.IO) {
            return@withContext model.getResultados()
        }
    }

    private fun DESCARGARCANCIONES() {
        lifecycleScope.launch {
            val list = CANCIONES()
            setAdapterOnMainThread(list)
        }
    }

    private suspend fun CANCIONES(): MutableList<MusicModel> {
        return withContext(Dispatchers.IO) {
            return@withContext model.getResultados()
        }
    }

    suspend fun setAdapterOnMainThread(music: List<MusicModel>) {
        withContext(Dispatchers.Main) {
            binding.vista
            music.forEach {
                Log.w("prueba",it.cancion)
            }
            Log.e("inicio","holaaaa")

            var listaFiltrada = music.filter { it.decada == 80 }

            listaFiltrada.forEach {
                Log.w("prueba",it.cancion)
            }
        }

    }

}



