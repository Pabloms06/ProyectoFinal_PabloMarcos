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
         return music.size
     }


     override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {


         music.forEach {

             Picasso.get().load(music[position].foto).into(holder.fotobanda)
             holder.banda.text = music[position].banda
             holder.descripcion.text = music[position].descripcion
             holder.cancion.text = music[position].cancion
             holder.anio.text = music[position].anio
             holder.integrantes.text = music[position].integrantes.toString()
         }

     }

     //Log.d("imagen", it.foto)

     /*holder.banda.text = it.banda
     holder.descripcion.text = it.descripcion
     holder.integrantes.text = it.integrantes.toString()
     holder.cancion.text = it.cancion
     holder.anio.text = it.anio*/

 }
