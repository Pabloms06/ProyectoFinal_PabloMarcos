 package com.example.proyectofinal_pablomarcos

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cbellmont.ejemplodescargainternet.MusicModel
import com.example.proyectofinal_pablomarcos.databinding.MusicLayoutBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.music_layout.*

 class MusicAdapter : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

     lateinit var binding: MusicLayoutBinding


     class MusicViewHolder(root: View, var fotobanda: ImageView, var banda: TextView, var descripcion: TextView, var anio: TextView, var cancion: TextView, var integrantes: TextView) : RecyclerView.ViewHolder(root)

     private var music = mutableListOf<MusicModel>()

     fun updateMusic(musicList: MutableList<MusicModel>) {
         this.music = musicList
         notifyDataSetChanged()
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
         binding = MusicLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         return MusicViewHolder(binding.root, binding.fotobanda, binding.banda, binding.descripcion, binding.anio, binding.cancion, binding.integrantes)
     }

     override fun getItemCount(): Int {
         return music.size
     }

     override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {

            /*music.forEach {
                 Log.w("Banda",it.banda)
             }
             Log.e("inicio","holaaaa")*/

             var listFiltrate1 = music.filter { it.genero == "Rock" }.filter { it.decada == 90 }


             listFiltrate1.forEach {

                 Log.w("Banda",it.banda)
                 //var bandalista = it.banda
                 //holder.banda.text = bandalista
             }

             //**********************

             listFiltrate1.forEach {

                 Log.w("Descripcion",it.banda)
                 //var desc = it.descripcion
                 //holder.descripcion.text = desc
             }

             //*******************

             listFiltrate1.forEach {

             Log.w("Integrantes",it.banda)
             //var integranteslista = it.integrantes.toString()
             //holder.integrantes.text = integranteslista
             }

             //***********************

             listFiltrate1.forEach {

                 Log.w("Cancion",it.banda)
                 //var song = it.cancion
                 //holder.cancion.text = song
             }

             //**********************

            listFiltrate1.forEach {

             Log.w("Año",it.banda)
             //var anio = it.anio
             //holder.anio.text = anio
         }

             /*
             var listaimagenes = music.filter { it.genero == "Rock" }.filter { it.decada == 90 }

              listaimagenes.forEach {
                  Log.d("imagen", it.foto)
                  Picasso.get().load(listaimagenes[position].foto)
              }

              for (num in listaimagenes.indices) {
                  holder.fotobanda.setImageResource(num)
              }


              holder.banda.text = listaimagenes[position].banda
              holder.descripcion.text = listaimagenes[position].descripcion
              holder.anio.text = listaimagenes[position].anio
              holder.cancion.text = listaimagenes[position].cancion
              holder.integrantes.text = listaimagenes[position].integrantes.toString()

              */

         }
 }
