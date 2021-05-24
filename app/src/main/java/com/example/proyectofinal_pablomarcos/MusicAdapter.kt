 package com.example.proyectofinal_pablomarcos

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal_pablomarcos.MusicModel
import com.example.proyectofinal_pablomarcos.databinding.MusicLayoutBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.music_layout.*
import org.w3c.dom.Text

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
         return listFiltrate1.size
     }

     var listFiltrate1 = music.filter { it.genero == "Rock" }.filter { it.decada == 90 }

     override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {


         listFiltrate1.forEach {
             //Log.d("imagen", it.foto)
             Picasso.get().load(listFiltrate1[position].foto)
         }

         listFiltrate1.forEach {

             //Log.w("Banda",it.banda)
             var bandalista = it.banda
             holder.banda.text = bandalista
         }
         //**********************

         listFiltrate1.forEach {
             //Log.w("Descripcion",it.descripcion)
             var desc = it.descripcion
             holder.descripcion.text = desc
         }

         //*******************

         listFiltrate1.forEach {

             //Log.w("Integrantes",it.integrantes.toString())
             var integranteslista = it.integrantes.toString()
             holder.integrantes.text = integranteslista.toString()
         }

         //***********************

         listFiltrate1.forEach {

             Log.w("Cancion",it.cancion)
             var song = it.cancion
             holder.cancion.text = song
         }

         //**********************

         listFiltrate1.forEach {

             Log.w("Año",it.anio)
             var anio= it.anio
             holder.anio.text = anio
         }



/*

         holder.banda.text = listFiltrate1[position].banda
         holder.descripcion.text = listFiltrate1[position].descripcion
         holder.anio.text = listFiltrate1[position].anio
         holder.cancion.text = listFiltrate1[position].cancion
         holder.integrantes.text = listFiltrate1[position].integrantes.toString()
*/
     }

 }
