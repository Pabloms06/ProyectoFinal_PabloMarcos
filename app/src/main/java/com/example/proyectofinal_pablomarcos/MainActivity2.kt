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
import com.example.proyectofinal_pablomarcos.MusicModel
import com.example.proyectofinal_pablomarcos.databinding.ActivityMain2Binding
import kotlinx.android.synthetic.main.activity_main_2.*
import kotlinx.android.synthetic.main.music_layout.*
import kotlinx.android.synthetic.main.music_layout.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity2 : AppCompatActivity() {
    private var adapter: MusicAdapter = MusicAdapter()
    //private lateinit var model: MainActivityViewModel
    private lateinit var binding: ActivityMain2Binding


    private var selecciondecada = ""
    private var selecciongenero = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        recibirdatos()

        GetAllMusic.send(this)

        createRecyclerView()

    }

    private fun recibirdatos() {
        val intent: Intent = intent
        var selecciondecadanull = intent.getStringExtra("decada")
        var selecciongeneronull = intent.getStringExtra("genero")
        Log.d("Recibir datos", "selecciondecadanull = $selecciondecadanull")
        selecciondecadanull?.let {
            selecciondecada = it
        }
        selecciongeneronull?.let {
            selecciongenero = it
        }

    }

    private fun createRecyclerView() {
        binding.vista.layoutManager = LinearLayoutManager(this)
        binding.vista.adapter = adapter
    }

    suspend fun setAdapterOnMainThread(music: MutableList<MusicModel>) {


       // Log.e("selecciongenero = ", selecciongenero)
       // Log.e("selecciondecada = ", selecciondecada)
        withContext(Dispatchers.Main) {


            //val listaFiltrada1 = music.filter { it.genero == selecciongenero }.filter { it.decada == selecciondecada.toInt() }

            val listaFiltrada1 = music.filter { it.genero == "Flamenco" }.filter { it.decada == 80 }


            Log.d("Lista filtrada",listaFiltrada1.toString())
            listaFiltrada1.forEach {
                Log.e("genero", it.genero)
            }
            //Log.w("ListaFiltrada",listaFiltrada1.toString())
            //Log.e("Seleccion genero",selecciongenero.toString())
            adapter.updateMusic(listaFiltrada1.toMutableList())

            pbLoading.visibility = View.GONE


        }

    }

}

