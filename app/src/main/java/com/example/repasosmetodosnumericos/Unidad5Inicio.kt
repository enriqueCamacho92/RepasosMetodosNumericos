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

        binding.tvUnidad5Puntaje.text = quiz5Score.toString() + " pts"

        firebaseDB.collection("app").document("quiz5").get().addOnSuccessListener {
            binding.tvUnidad5Tiempo.setText(it.get("tiempo") as String?)
        }

        binding.btnUnidad5Volver.setOnClickListener {
            startActivity(Intent(this, MenuPrincipal::class.java))
        }

        binding.btnUnidad5Comenzar.setOnClickListener {
            startActivity(Intent(this, Unidad5Quiz::class.java))
        }
    }
}