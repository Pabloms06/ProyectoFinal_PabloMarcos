package com.example.proyectofinal_pablomarcos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cbellmont.ejemplodescargainternet.MusicModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.filterList


class MainActivityViewModel  : ViewModel() {

    private val music = mutableListOf<MusicModel>()

    companion object {
        const val PARAM1 = "datos"
        const val PARAM2 = "datos"
    }

    suspend fun getGenero(): MutableList<MusicModel> {
        delay(2000)
        return music.filterList { PARAM1 }}
    }


    suspend fun getDecada() : MutableList<MusicModel> {
        delay(2000)
        return music.subList(3,6)
    }

    suspend fun getGeneroDecada() : MutableList<MusicModel> {
        delay(2000)
        return
    }
}