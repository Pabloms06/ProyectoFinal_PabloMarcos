package com.example.proyectofinal_pablomarcos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cbellmont.ejemplodescargainternet.MusicModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivityViewModel  : ViewModel() {

    private val music = mutableListOf<MusicModel>()

    suspend fun getGenero(): MutableList<MusicModel> {
        delay(2000)
        return music.filter {  }
    }


    suspend fun getDecada() : MutableList<MusicModel> {
        delay(2000)
        return films.subList(3,6)
    }

    suspend fun getGeneroDecada() : MutableList<MusicModel> {
        delay(2000)
        return
    }
}