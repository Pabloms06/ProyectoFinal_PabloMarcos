package com.example.proyectofinal_pablomarcos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal_pablomarcos.databinding.ActivityMain2Binding
import kotlinx.android.synthetic.main.activity_main_2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MainActivity2 : AppCompatActivity() {
    private var adapter: MusicAdapter = MusicAdapter()
    private lateinit var binding: ActivityMain2Binding


    private var selecciondecada = 0
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
        selecciondecada = intent.getIntExtra("decada",selecciondecada)
        selecciongenero = intent.getStringExtra("decada").toString()
       // Log.d("Recibir datos", "selecciondecadanull = $selecciondecadanull")
       /* selecciondecadanull?.let {
            selecciondecada = it
        }
        selecciongeneronull?.let {
            selecciongenero = it
        }*/

    }

    private fun createRecyclerView() {
        binding.vista.layoutManager = LinearLayoutManager(this)
        binding.vista.adapter = adapter
    }

    suspend fun setAdapterOnMainThread(music: MutableList<MusicModel>) {


        withContext(Dispatchers.Main) {


            val listaFiltrada1 = music.filter { it.genero == "Flamenco" }.filter { it.decada == 70 }


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

