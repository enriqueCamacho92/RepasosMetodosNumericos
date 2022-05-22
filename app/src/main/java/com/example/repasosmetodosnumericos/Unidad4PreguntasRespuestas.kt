package com.example.repasosmetodosnumericos

object Unidad4PreguntasRespuestas {
    var preguntas = arrayOf(
        R.drawable.quiz4preg1,
        R.drawable.quiz4preg2,
        R.drawable.quiz4preg3,
        R.drawable.quiz4preg4,
        R.drawable.quiz4preg5
    )
    var opciones = arrayOf(
        arrayOf("2.008443615+0.633695283x=g(x)", "1.008443615+1.633695283x=g(x)", "4.008443615+0.633695283x=g(x)", "2.008443615+2.633695283x=g(x)"),
        arrayOf("Línea Recta", "Mínimos Cuadrados", "Cúbica","Cuadrática"),
        arrayOf("Mínimos Cuadrados", "Línea Recta", "Cuadrática","Cúbica"),
        arrayOf("Mínimos Cuadrados", "Cuadrática", "Línea Recta","Cúbica"),
        arrayOf("Lineal con Función", "Mínimos Cuadrados", "Cúbica","Línea Recta")
    )
    var respuestasCorrectas = arrayOf(
        "2.008443615+0.633695283x=g(x)",
        "Mínimos Cuadrados",
        "Cuadrática",
        "Ecuación Lineal",
        "Lineal con Función"
    )
}