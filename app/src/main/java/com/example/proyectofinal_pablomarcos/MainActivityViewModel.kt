package com.example.proyectofinal_pablomarcos

import android.content.Intent
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

    suspend fun getResultados(): MutableList<MusicModel> {
        delay(2000)
        return music

        suspend fun getMusic(): MutableList<MusicModel> {
            delay(2000)
            return music.filterIndexedTo()
        }
    }

}