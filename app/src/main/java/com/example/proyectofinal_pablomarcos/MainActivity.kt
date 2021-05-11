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
                var setenta = radioButton70.text
                mutableList1.add(setenta.toString())
            }
            if (radioButton80.isChecked){
                var ochenta = radioButton80.text
                mutableList1.add(ochenta.toString())
            }
            if (radioButton90.isChecked){
                var noventa = radioButton90.text
                mutableList1.add(noventa.toString())
            }
            if (radioButton2000.isChecked){
                var dosmil = radioButton2000.text
                mutableList1.add(dosmil.toString())
            }
            if (radioButton2010.isChecked){
                var dosmildiez = radioButton2010.text
                mutableList1.add(dosmildiez.toString())
            }

        if (radioButtonrock.isChecked){
                var rock = radioButtonrock.text
                mutableList.add(rock.toString())
            }
            if (radioButtonpop.isChecked){
                var pop = radioButtonpop.text
                mutableList.add(pop.toString())
            }
            if (radioButtonflamenco.isChecked){
                var flamenco = radioButtonflamenco.text
                mutableList.add(flamenco.toString())
            }
            if (radioButtonrap.isChecked){
                var rap = radioButtonrap.text
                mutableList.add(rap.toString())
            }
            if (radioButtonreggaeton.isChecked){
                var reggaeton = radioButtonreggaeton.text
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


