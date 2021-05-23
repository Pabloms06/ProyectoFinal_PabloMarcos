package com.example.proyectofinal_pablomarcos
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1100)
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.send)

        var selecciondecada = ""
        var selecciongenero = ""

            if (radioButton70.isChecked){
               selecciondecada = "70"
            }
            if (radioButton80.isChecked){
                selecciondecada = "80"
            }
            if (radioButton90.isChecked){
                selecciondecada  = "90"
            }
            if (radioButton2000.isChecked){
                selecciondecada  = "2000"
            }
            if (radioButton2010.isChecked){
                selecciondecada  = "2010"
            }


            if (radioButtonrock.isChecked){
                selecciongenero = "Rock"
            }
            if (radioButtonpop.isChecked){
                selecciongenero = "Pop"
            }
            if (radioButtonflamenco.isChecked){
                selecciongenero = "Flamenco"
            }
            if (radioButtonrap.isChecked){
                selecciongenero = "Rap"
            }
            if (radioButtonindi.isChecked){
                selecciongenero= "Rock"
            }
            if (radioButtonreggaeton.isChecked){
                selecciongenero = "Reggaeton"
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



