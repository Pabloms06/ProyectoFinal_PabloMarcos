package com.example.proyectofinal_pablomarcos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cbellmont.ejemplodescargainternet.databinding.ActivityMainBinding
import com.example.proyectofinal_pablomarcos.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

interface MainActivityInterface {
    suspend fun onFilmsReceived(listFilms : List<MusicModel>)
}

// IMPORTANT: Passing the activity to a the receiver is not a good practice, it may cause issues
// with the activity-s lifecycle. We are doing it just to keep the focus on the target of this example
class MainActivity : AppCompatActivity(), MainActivityInterface {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        setContentView(R.layout.music_layout)


        CoroutineScope(Dispatchers.IO).launch{
            MainActivity2.GetAllMusic.send(this@MainActivity)
        }
    }

    override suspend fun onFilmsReceived(listFilms : List<MusicModel>) {
        withContext(Dispatchers.Main){
            binding..text = ""  //Cambia el mensaje de el textview por "" y a continuacion añade la lista, que este caso es Film
            listFilms.forEach {
                .append(it.toString())
            }
        }

    }
}
