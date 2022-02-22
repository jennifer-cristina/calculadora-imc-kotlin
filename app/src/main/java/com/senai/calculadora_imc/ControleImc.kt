package com.senai.calculadora_imc

fun calcularImc(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}

fun situacaoAluno(imc: Double): String {
    if (imc < 18.5)
        return "você está abaixo do peso."
    else if (imc < 25)
        return "você está com peso ideal!"
    else if (imc < 30)
        return "você está levemente acima do peso."
    else if (imc < 35)
        return "você está com obesidade grau I"
    else if (imc < 40)
        return "você está com obesidade grau II"
    else
        return "você está com obesidade grau III."
}