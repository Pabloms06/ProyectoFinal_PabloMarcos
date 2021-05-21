package com.example.proyectofinal_pablomarcos

import com.google.gson.annotations.SerializedName
data class MusicModel(

    @SerializedName("id")var Id : String,
    @SerializedName("decada")var decada: Int,
    @SerializedName("genero") var genero : String,
    @SerializedName("banda")  var banda : String,
    @SerializedName("foto") var foto : String,
    @SerializedName("descripcion") var descripcion : String,
    @SerializedName("anio") var anio : String,
    @SerializedName("cancion") var cancion : String,
    @SerializedName("integrantes")var integrantes: List<String>?)
{
    override fun toString(): String {
        return "$descripcion"
    }


}
