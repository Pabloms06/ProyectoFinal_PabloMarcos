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
import kotlinx.android.synthetic.main.music_layout.view.*
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

    suspend fun setAdapterOnMainThread(music: MutableList<MusicModel>) {
        withContext(Dispatchers.Main) {
            adapter.updateMusic(music)
            pbLoading.visibility = View.GONE

            binding.vista
            music.forEach {
                Log.w("Banda",it.banda)
            }
            Log.e("inicio","holaaaa")

            var listaFiltrada1 = music.filter { it.genero == "Rock" }.filter { it.decada == 90 }

            listaFiltrada1.forEach {

                //Log.w("Banda",it.banda)
                var bandalista = it.banda
                banda.text = bandalista
            }


            //Separador



            music.forEach {
                Log.w("prueba",it.descripcion)
            }
            Log.e("Descripcion","Descripcion")

             var listaFiltrada2 = music.filter { it.genero == "Rock" }.filter { it.decada == 90 }

            listaFiltrada2.forEach {
                Log.w("Descripcion",it.descripcion)
            }

            //Separador


            music.forEach {
                Log.w("prueba",it.anio)
            }
            Log.e("Año","Año")


            var listaFiltrada3 = music.filter { it.genero == "Rock" }.filter { it.decada == 90 }

            listaFiltrada3.forEach {
                Log.w("Año",it.anio)
            }

            //Separador



            music.forEach {
                Log.w("prueba",it.cancion)
            }
            Log.e("Cancion","Cancion")


            var listaFiltrada4 = music.filter { it.genero == "Rock" }.filter { it.decada == 90 }


            listaFiltrada4.forEach {
                Log.w("Cancion",it.cancion)
            }

            //Separador



            music.forEach {
                Log.w("prueba",it.integrantes.toString())
            }
            Log.e("Integrantes","Integrantes")

            var listaFiltrada5 = music.filter { it.genero == "Rock" }.filter { it.decada == 90 }

            listaFiltrada5.forEach {
                Log.w("Integrantes",it.integrantes.toString())
            }
        }




    }

}



