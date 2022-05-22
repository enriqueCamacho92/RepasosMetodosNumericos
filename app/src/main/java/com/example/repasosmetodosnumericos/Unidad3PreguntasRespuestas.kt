package com.example.repasosmetodosnumericos

object Unidad3PreguntasRespuestas {
    var preguntas = arrayOf(
        R.drawable.quiz3preg1,
        R.drawable.quiz3preg2,
        R.drawable.quiz3preg3,
        R.drawable.quiz3preg4,
        R.drawable.quiz3preg5
    )
    var opciones = arrayOf(
        arrayOf("a=52/67, b=29/77 c=65/67", "a=62/87, b=19/87 c=66/87", "a=50/87, b=19/18 c=66/59", "a=62/87, b=29/27 c=70/97"),
        arrayOf("a=-1, b=1/2, c=1/2", "a=1, b=1/5, c=5/2", "a=-1, b=1/2, c=5/2","a=-5, b=1/3, c=5/2"),
        arrayOf("x1=1, x2=8, x3=4", "x1=2, x2=3, x3=6", "x1=2, x2=4, x3=2","x1=1, x2=3, x3=2"),
        arrayOf("Cuadrática", "Ecuación Lineal", "Ecuación 2o Grado","Ecuación Algebráica Lineal"),
        arrayOf("Ecuación Algebráica Lineal", "Ecuación Lineal", "Ecuación 2o Grado","Cuadrática")
    )
    var respuestasCorrectas = arrayOf(
        "a=62/87, b=19/87 c=66/87",
        "a=-1, b=1/2, c=5/2",
        "x1=1, x2=3, x3=2",
        "Ecuación Lineal",
        "Ecuación Algebráica Lineal"
    )
}