package com.example.repasosmetodosnumericos

object Unidad5PreguntasRespuestas {
    var preguntas = arrayOf(
        R.drawable.quiz5preg1,
        R.drawable.quiz5preg2,
        R.drawable.quiz5preg3,
        R.drawable.quiz5preg4,
        R.drawable.quiz5preg5
    )
    var opciones = arrayOf(
        arrayOf("I=0.142416952", "I=0.252416952", "I=1.142416952", "I=2.252416952"),
        arrayOf("I=-80", "I=-40", "I=-30","I=-140"),
        arrayOf("I=1.35189715", "I=0.35189715", "I=0.14189715","I=0.24189715"),
        arrayOf("I=1.575583627", "I=2.575583627", "I=0.475583627","I=0.575583627"),
        arrayOf("Integración", "Regla Trapezoidal", "Newton-Cotes Abiertas","Newton-Cotes Cerradas")
    )
    var respuestasCorrectas = arrayOf(
        "I=0.142416952",
        "I=-40",
        "I=0.14189715",
        "I=0.575583627",
        "Integración"
    )
}