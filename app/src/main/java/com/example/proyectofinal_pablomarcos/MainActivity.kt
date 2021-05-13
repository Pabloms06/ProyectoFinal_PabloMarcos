package com.example.proyectofinal_pablomarcos
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mutableList1 : MutableList<String> = mutableListOf()
        var mutableList : MutableList<String> = mutableListOf()
        val boton = findViewById<Button>(R.id.send)



            if (radioButton70.isChecked){
                var setenta = "70"
                mutableList1.add(setenta)
            }
            if (radioButton80.isChecked){
                var ochenta = "80"
                mutableList1.add(ochenta.toString())
            }
            if (radioButton90.isChecked){
                var noventa = "90"
                mutableList1.add(noventa)
            }
            if (radioButton2000.isChecked){
                var dosmil = "2000"
                mutableList1.add(dosmil)
            }
            if (radioButton2010.isChecked){
                var dosmildiez = "2010"
                mutableList1.add(dosmildiez)
            }

        if (radioButtonrock.isChecked){
                var rock = "Rock"
                mutableList.add(rock)
            }
            if (radioButtonpop.isChecked){
                var pop = "Pop"
                mutableList.add(pop.toString())
            }
            if (radioButtonflamenco.isChecked){
                var flamenco = "Flamenco"
                mutableList.add(flamenco)
            }
            if (radioButtonrap.isChecked){
                var rap = "Rap"
                mutableList.add(rap.toString())
            }
            if (radioButtonreggaeton.isChecked){
                var reggaeton = "Reggaeton"
                mutableList.add(reggaeton.toString())
            }





        boton.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("lista1",mutableList.toString())
            intent.putExtra("lista2",mutableList1.toString())
            startActivity(intent)
        }




    }
}


