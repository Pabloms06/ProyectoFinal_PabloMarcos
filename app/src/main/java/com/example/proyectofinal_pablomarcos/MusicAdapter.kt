package com.example.proyectofinal_pablomarcos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.proyectofinal_pablomarcos.databinding.FilmLayoutBinding
import androidx.recyclerview.widget.RecyclerView
import com.cbellmont.ejemplodescargainternet.MusicModel
import com.example.proyectofinal_pablomarcos.databinding.MusicLayoutBinding

class MusicAdapter : RecyclerView.Adapter<MusicAdapter.FilmsViewHolder>() {

    lateinit var binding : MusicLayoutBinding

    class FilmsViewHolder(root: View, var fotobanda : ImageView, var descripcion : TextView, var anio: TextView, var cancion: TextView, var integrantes : TextView) : RecyclerView.ViewHolder(root)

    private var music = mutableListOf<MusicModel>()

    fun updateFilms(filmsList: MutableList<MusicModel>) {
        this.music = filmsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        binding = MusicLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return FilmsViewHolder(binding.root, binding.fotobanda, binding.descripcion, binding.anio, binding.cancion,binding.integrantes)
    }

    override fun getItemCount(): Int {
        return music.size
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.tvIntro.text = films[position].intro
        holder.tvNombre.text = films[position].name
        if (position % 6 > 2){
            holder.ivIzquierda.visibility = View.GONE
            holder.ivDerecha.visibility = View.VISIBLE
            Picasso.get().load(films[position].getUrlImage()).into(holder.ivDerecha)
        }  else {
            holder.ivIzquierda.visibility = View.VISIBLE
            holder.ivDerecha.visibility = View.GONE
            Picasso.get().load(films[position].getUrlImage()).into(holder.ivIzquierda)
        }
    }
}