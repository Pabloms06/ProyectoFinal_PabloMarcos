package com.example.proyectofinal_pablomarcos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioButton radioButton1;
    RadioButton radioButton2;
    TextView textView1;
    TextView textview2;

    int selecciondecada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radiogroup2);

        textView1 = findViewById(R.id.decada);
        textview2 = findViewById(R.id.genero);

        Button button = findViewById(R.id.send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup1.getCheckedRadioButtonId();
                int radioId1 = radioGroup2.getCheckedRadioButtonId();

                radioButton1 = findViewById(radioId);
                radioButton2 = findViewById(radioId1);

                textView1.setText(radioButton1.getText());
                textview2.setText(radioButton2.getText());

                radioButton1 = findViewById(radioId);
                radioButton2 = findViewById(radioId1);


                CharSequence datodecada = textView1.getText();   //Coger el dato que se ha seleccionado

                selecciondecada = Integer.parseInt(String.valueOf(datodecada));  //Recoger el dato de la decada y pasarlo a Int

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("decada",selecciondecada);  //Pasar los datos
                i.putExtra("genero",textview2.getText().toString());
                startActivity(i);


            }
        });

        }

    }

