package com.senai.calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)
        val decimal = DecimalFormat("#.##")

        calcular.setOnClickListener(){
        val nome = findViewById<EditText>(R.id.nome).text.toString()
        val altura = findViewById<EditText>(R.id.altura).text.toString().toDouble()
        val peso = findViewById<EditText>(R.id.peso).text.toString().toDouble()
        val resultado = findViewById<TextView>(R.id.resultado)
        val calculo =   peso / (altura * altura)

            if( calculo < 18.5)
                resultado.text = nome + ", seu IMC é " + decimal.format(calculo) + "\n" + "você está abaixo do peso."
            else if(calculo < 25)
                resultado.text = nome + ", seu IMC é " + decimal.format(calculo) + "\n" + "você está com peso ideal!"
            else if(calculo < 30)
                resultado.text = nome + ", seu IMC é " + decimal.format(calculo) + "\n" + "você está levemente acima do peso."
            else if(calculo < 35)
                resultado.text = nome + ", seu IMC é " + decimal.format(calculo) + "\n" + "você está com obesidade grau I"
            else if(calculo < 40)
                resultado.text = nome + ", seu IMC é " + decimal.format(calculo) + "\n" + "você está com obesidade grau II"
            else
                resultado.text = nome + ", seu IMC é " + decimal.format(calculo) + "\n" + "você está com obesidade grau III."

        }

        sair.setOnClickListener(){
            finish()
        }

    }
}