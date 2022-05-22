package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad5InicioBinding
import com.google.firebase.firestore.FirebaseFirestore

class Unidad5Inicio : AppCompatActivity() {
    private lateinit var binding : ActivityUnidad5InicioBinding
    private lateinit var firebaseDB : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnidad5InicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseDB = FirebaseFirestore.getInstance()

        firebaseDB.collection("users").document(actualUserEmail).get().addOnSuccessListener {
            binding.tvUnidad5Puntaje.setText(it.get("unit5puntuacion") as String? + " pts")
        }

        binding.btnUnidad5Volver.setOnClickListener {
            startActivity(Intent(this, MenuPrincipal::class.java))
        }

        binding.btnUnidad5Comenzar.setOnClickListener {
            startActivity(Intent(this, Unidad5Quiz::class.java))
        }
    }
}