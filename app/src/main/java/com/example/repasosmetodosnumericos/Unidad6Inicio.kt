package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad6InicioBinding
import com.google.firebase.firestore.FirebaseFirestore

class Unidad6Inicio : AppCompatActivity() {
    private lateinit var binding : ActivityUnidad6InicioBinding
    private lateinit var firebaseDB : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnidad6InicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseDB = FirebaseFirestore.getInstance()

        firebaseDB.collection("users").document(actualUserEmail).get().addOnSuccessListener {
            binding.tvUnidad6Puntaje.setText(it.get("unit6puntuacion") as String? + " pts")
        }

        binding.btnUnidad6Volver.setOnClickListener {
            startActivity(Intent(this, MenuPrincipal::class.java))
        }

        binding.btnUnidad6Comenzar.setOnClickListener {
            startActivity(Intent(this, Unidad6Quiz::class.java))
        }
    }
}