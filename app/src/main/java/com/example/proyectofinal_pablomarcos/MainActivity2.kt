package com.example.proyectofinal_pablomarcos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.cbellmont.ejemplodescargainternet.MusicModel
import com.example.proyectofinal_pablomarcos.databinding.ActivityMain2Binding
import com.example.proyectofinal_pablomarcos.databinding.ActivityMainBinding
import kotlinx.coroutines.*

interface MainActivityInterface {
    suspend fun onMusicReceived(listFilms : List<MusicModel>)
}

class MainActivity2 : AppCompatActivity(), MainActivityInterface {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.music_layout)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO){
            GetAllMusic.send(this@MainActivity2)
        }
    }

    override suspend fun onMusicReceived(listFilms : List<MusicModel>) {
        withContext(Dispatchers.Main){
            binding.vista
            listFilms.forEach {
                binding..append(it.toString())
            }
        }

    }

}