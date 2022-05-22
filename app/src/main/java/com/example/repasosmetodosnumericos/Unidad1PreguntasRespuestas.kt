package com.example.repasosmetodosnumericos

object Unidad1PreguntasRespuestas {
    var preguntas = arrayOf(
        R.drawable.quiz1preg1,
        R.drawable.quiz1preg2,
        R.drawable.quiz1preg3,
        R.drawable.quiz1preg4,
        R.drawable.quiz1preg5
    )
    var opciones = arrayOf(
        arrayOf("g(x)=1.404007668", "g(x)=1.304007668", "g(x)=1.308007668", "g(x)=2.304007668"),
        arrayOf("g(x)=1.714444444", "g(x)=2.444444444", "g(x)=2.714444444","g(x)=2.814444444"),
        arrayOf("g(x)=-1.723076923", "g(x)=-1.823076923", "g(x)=-1.777076923","g(x)=-1.933076923"),
        arrayOf("Error Numérico", "Error de Redondeo", "Error de Truncamiento","Error Significativo"),
        arrayOf("Error de Redondeo", "Error Numérico", "Error de Truncamiento","Error significativo")
    )
    var respuestasCorrectas = arrayOf(
        "g(x)=1.304007668",
        "g(x)=2.714444444",
        "g(x)=-1.723076923",
        "Error de Truncamiento",
        "Error de Redondeo"
    )
}
