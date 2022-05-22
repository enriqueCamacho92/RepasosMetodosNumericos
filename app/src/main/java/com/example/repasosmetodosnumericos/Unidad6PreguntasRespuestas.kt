package com.example.repasosmetodosnumericos

object Unidad6PreguntasRespuestas {
    var preguntas = arrayOf(
        R.drawable.quiz6preg1,
        R.drawable.quiz6preg2,
        R.drawable.quiz6preg3,
        R.drawable.quiz6preg4,
        R.drawable.quiz6preg5
    )
    var opciones = arrayOf(
        arrayOf("y1=1.933333333, y2=1.995555556", "y1=2.933333333, y2=2.995555556", "y1=2, y2=2", "y1=0.933333333, y2=0.995555556"),
        arrayOf("y'1=1.939", "y'1=0.939", "y'1=1","y'1=2.939"),
        arrayOf("y1=1.651632664", "y1=0.851632664", "y1=0.651632664","y1=1.851632664"),
        arrayOf("y1=1.411723276", "y1=4.211723276", "y1=0.211723276","y1=1.211723276"),
        arrayOf("Método Runge-Kutta", "Euler Modificado", "Euler Hacia Atras","Euler Hacia Adelante")
    )
    var respuestasCorrectas = arrayOf(
        "y1=1.933333333, y2=1.995555556",
        "y'1=0.939",
        "y1=0.651632664",
        "y1=1.211723276",
        "Método Runge-Kutta"
    )
}