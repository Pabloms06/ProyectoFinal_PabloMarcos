package com.example.proyectofinal_pablomarcos
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.send)

        var selecciondecada = ""
        var selecciongenero = ""

            if (radioButton70.isChecked){
                var selecciondecada = "70"
            }
            if (radioButton80.isChecked){
                var selecciondecada = "80"
            }
            if (radioButton90.isChecked){
                var selecciondecada  = "90"
            }
            if (radioButton2000.isChecked){
                var selecciondecada  = "2000"
            }
            if (radioButton2010.isChecked){
                var selecciondecada  = "2010"
            }


            if (radioButtonrock.isChecked){
                var selecciongenero = "Rock"
            }
            if (radioButtonpop.isChecked){
                var selecciongenero = "Pop"
            }
            if (radioButtonflamenco.isChecked){
                var selecciongenero = "Flamenco"
            }
            if (radioButtonrap.isChecked){
                var selecciongenero = "Rap"
            }
            if (radioButtonindi.isChecked){
                var selecciongenero= "Rock"
            }
            if (radioButtonreggaeton.isChecked){
                var selecciongenero = "Reggaeton"
            }


        boton.setOnClickListener{
            Toast.makeText(this, "Información enviada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("decada",selecciondecada)
            intent.putExtra("genero",selecciongenero)
            startActivity(intent)
        }


    }
}



