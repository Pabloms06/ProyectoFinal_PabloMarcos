package com.example.proyectofinal_pablomarcos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cbellmont.ejemplodescargainternet.MusicModel
import com.example.proyectofinal_pablomarcos.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface MainActivityInterface {
    suspend fun onFilmsReceived(listMusic : List<MusicModel>)
}

class MainActivity2 : AppCompatActivity() {
    companion object {
        const val PARAM1 = "datos"
        const val PARAM2 = "datos"
    }

    private var adapter: MusicAdapter = MusicAdapter()
    private lateinit var model: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        createRecyclerView()
        downloadAll()

        binding.bAntiguas.setOnClickListener {
            binding.pbLoading.visibility = View.VISIBLE
            downloadOldFilm()
        }

        binding.bNuevas.setOnClickListener {
            binding.pbLoading.visibility = View.VISIBLE
            downloadNewFilm()
        }

        binding.bTodas.setOnClickListener {
            binding.pbLoading.visibility = View.VISIBLE
            downloadAll()
        }
    }

    private fun createRecyclerView() {
        binding. = LinearLayoutManager(this)
        binding.vista.adapter = adapter
    }

    private fun downloadOldFilm() {
        lifecycleScope.launch {
            val list = loadFilmOldInBackground()
            setAdapterOnMainThread(list)
        }
    }

    private suspend fun loadFilmOldInBackground(): MutableList<MusicAdapter> {
        // El withContext(Dispatchers.IO) no es estrictamente necesario. Lo ponemos solo por seguridad.
        return withContext(Dispatchers.IO) {
            return@withContext model.getOldFilms()
        }
    }

    private fun downloadNewFilm() {
        lifecycleScope.launch {
            val list = loadFilmNewInBackground()
            setAdapterOnMainThread(list)
        }
    }

    private suspend fun loadFilmNewInBackground(): MutableList<MusicAdapter> {
        // El withContext(Dispatchers.IO) no es estrictamente necesario. Lo ponemos solo por seguridad.
        return withContext(Dispatchers.IO) {
            return@withContext model.getNewFilms()
        }
    }

    private fun downloadAll() {
        lifecycleScope.launch {
            val list = loadMusicAllInBackground()
            setAdapterOnMainThread(list)
        }
    }

    private suspend fun loadMusicAllInBackground(): MutableList<MusicAdapter> {
        // El withContext(Dispatchers.IO) no es estrictamente necesario. Lo ponemos solo por seguridad.
        return withContext(Dispatchers.IO) {
            return@withContext model.getMusic()
        }
    }

    private suspend fun setAdapterOnMainThread(filmsList: MutableList<MusicAdapter>) {
        withContext(Dispatchers.Main) {
            adapter.updateFilms(filmsList)
            pbLoading.visibility = View.GONE
        }
    }



