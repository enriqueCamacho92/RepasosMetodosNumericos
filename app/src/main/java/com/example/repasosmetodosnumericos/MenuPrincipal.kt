package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasosmetodosnumericos.databinding.ActivityMenuPrincipalBinding
import com.google.firebase.firestore.FirebaseFirestore

var globalScore: Float = 0f
var quiz1Score: Float = 0f
var quiz2Score: Float = 0f
var quiz3Score: Float = 0f
var quiz4Score: Float = 0f
var quiz5Score: Float = 0f
var quiz6Score: Float = 0f
var pruebasContestadas: Int = 0
var quiz1: String = "No"
var quiz2: String = "No"
var quiz3: String = "No"
var quiz4: String = "No"
var quiz5: String = "No"
var quiz6: String = "No"

class MenuPrincipal : AppCompatActivity() {
    private lateinit var binding : ActivityMenuPrincipalBinding
    private lateinit var firebaseDB : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseDB = FirebaseFirestore.getInstance()
        firebaseDB.collection("users").document(actualUserEmail).get().addOnSuccessListener {
            binding.tvMenuPrincipalNombre.setText(it.get("nombre") as String?)
        }

        globalScore=(quiz1Score+ quiz2Score+ quiz3Score+ quiz4Score+ quiz5Score+ quiz6Score)/6

        binding.tvMenuPrincipalPuntuacion.text = globalScore.toString() + " pts"
        binding.tvMenuPrincipalPruebasContestadas.text = pruebasContestadas.toString()
        binding.tvMenuPrinipalUnidad1Puntuacion.text = quiz1Score.toString() + " pts"
        binding.tvMenuPrinipalUnidad1Realizado.text = quiz1
        binding.tvMenuPrinipalUnidad2Puntuacion.text = quiz2Score.toString() + " pts"
        binding.tvMenuPrinipalUnidad2Realizado.text = quiz2
        binding.tvMenuPrinipalUnidad3Puntuacion.text = quiz3Score.toString() + " pts"
        binding.tvMenuPrinipalUnidad3Realizado.text = quiz3
        binding.tvMenuPrinipalUnidad4Puntuacion.text = quiz4Score.toString() + " pts"
        binding.tvMenuPrinipalUnidad4Realizado.text = quiz4
        binding.tvMenuPrinipalUnidad5Puntuacion.text = quiz5Score.toString() + " pts"
        binding.tvMenuPrinipalUnidad5Realizado.text = quiz5
        binding.tvMenuPrinipalUnidad6Puntuacion.text = quiz6Score.toString() + " pts"
        binding.tvMenuPrinipalUnidad6Realizado.text = quiz6

        binding.btnMenuPrincipalVolver.setOnClickListener{
            startActivity(Intent(this, LogIn::class.java))
        }

        binding.cvUnidad1.setOnClickListener {
            startActivity(Intent(this, Unidad1Inicio::class.java))
        }

        binding.cvUnidad2.setOnClickListener {
            startActivity(Intent(this, Unidad2Inicio::class.java))
        }

        binding.cvUnidad3.setOnClickListener {
            startActivity(Intent(this, Unidad3Inicio::class.java))
        }

        binding.cvUnidad4.setOnClickListener {
            startActivity(Intent(this, Unidad4Inicio::class.java))
        }

        binding.cvUnidad5.setOnClickListener {
            startActivity(Intent(this, Unidad5Inicio::class.java))
        }

        binding.cvUnidad6.setOnClickListener {
            startActivity(Intent(this, Unidad6Inicio::class.java))
        }
    }
}