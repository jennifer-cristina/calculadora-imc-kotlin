package com.senai.calculadora_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val nomeTextView = findViewById<TextView>(R.id.nome)
        val alturaTextView = findViewById<TextView>(R.id.altura)
        val pesoTextView = findViewById<TextView>(R.id.peso)
        val situacaotextView = findViewById<TextView>(R.id.situacao)

        // descreve a atividade a iniciar e carrega todos os dados necessários.
        val intent:Intent = getIntent()

        // inserir seta para voltar a tela anterior
        val actionBar =supportActionBar

        actionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        nomeTextView.text = intent.getStringExtra("nome")
        alturaTextView.text = intent.getStringExtra("altura")
        pesoTextView.text = intent.getStringExtra("peso")
        situacaotextView.text = intent.getStringExtra("situacao")

    }
}