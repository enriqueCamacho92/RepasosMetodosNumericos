package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad1InicioBinding
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad2InicioBinding
import com.google.firebase.firestore.FirebaseFirestore

class Unidad2Inicio : AppCompatActivity() {
    private lateinit var binding : ActivityUnidad2InicioBinding
    private lateinit var firebaseDB : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnidad2InicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseDB = FirebaseFirestore.getInstance()

        firebaseDB.collection("users").document(actualUserEmail).get().addOnSuccessListener {
            binding.tvUnidad2Puntaje.setText(it.get("unit2puntuacion") as String? + " pts")
        }

        binding.btnUnidad2Volver.setOnClickListener {
            startActivity(Intent(this, MenuPrincipal::class.java))
        }

        binding.btnUnidad2Comenzar.setOnClickListener {
            startActivity(Intent(this, Unidad2Quiz::class.java))
        }
    }
}