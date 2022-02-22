package com.senai.calculadora_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

    private lateinit var nomeEditText:EditText
    private lateinit var alturaEditText: EditText
    private lateinit var pesoEditText: EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Chamando o conteúdo da TextView pelo id e colocando em uma variável
        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)
        val decimal = DecimalFormat("#.##")

        calcular.setOnClickListener(){

        nomeEditText = findViewById(R.id.nome)
        alturaEditText = findViewById(R.id.altura)
        pesoEditText = findViewById(R.id.peso)

        val resultadoTextView = findViewById<TextView>(R.id.resultado)

        if(validarCampos()) {

            val nome = nomeEditText.text.toString()
            val altura = alturaEditText.text.toString().toDouble()
            val peso = pesoEditText.text.toString().toDouble()

            val imc = calcularImc(peso, altura)

            // classe responsável por chamar a classe ResultadoActivity
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("nome", nomeEditText.text.toString())
            intent.putExtra("altura", "${altura}")
            intent.putExtra("peso", "${peso}")
            intent.putExtra("situacao", situacaoAluno(imc   ))
            startActivity(intent)

        }

        }

        sair.setOnClickListener(){
            finish()
        }

    }

    fun validarCampos(): Boolean {
        var noError = true
        if (nomeEditText.text.isBlank()) {
            nomeEditText.setError("Digite seu nome!")
            noError = false
        }

        if (alturaEditText.text.isBlank()) {
            alturaEditText.setError("Digite sua altura!")
            noError = false
        }

        if (pesoEditText.text.isBlank()) {
            pesoEditText.setError("Digite seu peso!")
            noError = false
        }

        return noError
    }
}