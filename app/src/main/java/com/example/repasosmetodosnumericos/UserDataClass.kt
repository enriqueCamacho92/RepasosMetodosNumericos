package com.example.repasosmetodosnumericos

data class User(var nombre: String,
                   var puntuacion: String,
                   var tests: String){
    constructor() : this(
        "",
        "",
        ""
    )
}