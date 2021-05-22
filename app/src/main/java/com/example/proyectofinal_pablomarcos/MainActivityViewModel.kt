package com.example.proyectofinal_pablomarcos


import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.proyectofinal_pablomarcos.MusicModel
import com.example.proyectofinal_pablomarcos.databinding.ActivityMain2Binding
import kotlinx.coroutines.delay
import okhttp3.internal.filterList


class MainActivityViewModel  : ViewModel() {

    private val music = mutableListOf<MusicModel>()

    suspend fun getResultados(): MutableList<MusicModel> {
        delay(2000)
        return music

    }

}