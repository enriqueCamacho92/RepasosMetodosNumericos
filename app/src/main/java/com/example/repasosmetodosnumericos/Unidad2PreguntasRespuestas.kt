package com.example.repasosmetodosnumericos

object Unidad2PreguntasRespuestas {
    var preguntas = arrayOf(
        R.drawable.quiz2preg1,
        R.drawable.quiz2preg2,
        R.drawable.quiz2preg3,
        R.drawable.quiz2preg4,
        R.drawable.quiz2preg5
    )
    var opciones = arrayOf(
        arrayOf("x=1.409852575", "x=1.509852575", "x=2.409852575", "x=2.509852575"),
        arrayOf("x=1.245425782", "x=2.745425782", "x=1.745425782","x=2.245425782"),
        arrayOf("x=1.567143306", "x=2.567143306", "x=0.867143306","x=0.467143306"),
        arrayOf("Bisectriz", "Punto Fijo", "Secante","Método Gráfico"),
        arrayOf("Secante", "Bisectriz", "Punto Fijo","Método Gráfico")
    )
    var respuestasCorrectas = arrayOf(
        "x=1.409852575",
        "x=1.745425782",
        "x=0.567143306",
        "Método Gráfico",
        "Bisectriz"
    )
}