package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad3InicioBinding
import com.google.firebase.firestore.FirebaseFirestore

class Unidad3Inicio : AppCompatActivity() {
    private lateinit var binding : ActivityUnidad3InicioBinding
    private lateinit var firebaseDB : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnidad3InicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseDB = FirebaseFirestore.getInstance()

        firebaseDB.collection("users").document(actualUserEmail).get().addOnSuccessListener {
            binding.tvUnidad3Puntaje.setText(it.get("unit3puntuacion") as String? + " pts")
        }

        binding.btnUnidad3Volver.setOnClickListener {
            startActivity(Intent(this, MenuPrincipal::class.java))
        }

        binding.btnUnidad3Comenzar.setOnClickListener {
            startActivity(Intent(this, Unidad3Quiz::class.java))
        }
    }
}