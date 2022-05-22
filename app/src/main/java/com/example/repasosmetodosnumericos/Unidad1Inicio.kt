package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad1InicioBinding
import com.google.firebase.firestore.FirebaseFirestore

class Unidad1Inicio : AppCompatActivity() {
    private lateinit var binding : ActivityUnidad1InicioBinding
    private lateinit var firebaseDB : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnidad1InicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseDB = FirebaseFirestore.getInstance()

        binding.tvUnidad1Puntaje.text = quiz1Score.toString() + " pts"

        firebaseDB.collection("app").document("quiz1").get().addOnSuccessListener {
            binding.tvUnidad1Tiempo.setText(it.get("tiempo") as String?)
        }

        binding.btnUnidad1Volver.setOnClickListener {
            startActivity(Intent(this, MenuPrincipal::class.java))
        }

        binding.btnUnidad1Comenzar.setOnClickListener {
            startActivity(Intent(this, Unidad1Quiz::class.java))
        }
    }
}