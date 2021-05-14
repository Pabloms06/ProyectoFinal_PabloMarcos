package com.example.proyectofinal_pablomarcos


import androidx.lifecycle.ViewModel
import com.cbellmont.ejemplodescargainternet.MusicModel
import kotlinx.coroutines.delay


class MainActivityViewModel  : ViewModel() {

    private val music = mutableListOf<MusicModel>()

    suspend fun getResultados(): MutableList<MusicModel> {
        delay(2000)
        return music

    }

        /*suspend fun getMusic(): MutableList<MusicModel> {
            delay(2000)

        }
    }*/


}