package com.example.proyectofinal_pablomarcos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.cbellmont.ejemplodescargainternet.MusicModel
import com.example.proyectofinal_pablomarcos.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main_2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity2 : AppCompatActivity() {

    private var adapter: MusicAdapter = MusicAdapter()
    private lateinit var model: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intent : Intent=intent
        var mutablelist = intent.getStringArrayListExtra("lista1")
        var mutablelist1 = intent.getStringArrayListExtra("lista2")


        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        createRecyclerView()
        descargartodas()

    }

    private fun createRecyclerView() {
        binding. = LinearLayoutManager (this)
        binding.vista.adapter = adapter
    }

    private fun descargartodas(){
        lifecycleScope.launch {
            val list = DESCARGARTODAS()
            setAdapterOnMainThread(list)
        }
    }

    private suspend fun DESCARGARTODAS() : MutableList<MusicModel>{
        // El withContext(Dispatchers.IO) no es estrictamente necesario. Lo ponemos solo por seguridad.
        return withContext(Dispatchers.IO) {
            return@withContext model.getMusic()
        }
    }

    private fun DESCARGARCANCIONES() {
        lifecycleScope.launch {
            val list = CANCIONES()
            setAdapterOnMainThread(list)
        }
    }

    private suspend fun CANCIONES(): MutableList<MusicModel> {
        // El withContext(Dispatchers.IO) -> Seguridad.
        return withContext(Dispatchers.IO) {
            return@withContext model.getResultados()
        }
    }

    private suspend fun setAdapterOnMainThread(filmsList: MutableList<MusicModel>) {
        withContext(Dispatchers.Main) {
            adapter.updateFilms(filmsList)
            pbLoading.visibility = View.GONE
        }
    }

}



