package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad3InicioBinding
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad4InicioBinding
import com.google.firebase.firestore.FirebaseFirestore

class Unidad4Inicio : AppCompatActivity() {
    private lateinit var binding : ActivityUnidad4InicioBinding
    private lateinit var firebaseDB : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnidad4InicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseDB = FirebaseFirestore.getInstance()

        binding.tvUnidad4Puntaje.text = quiz4Score.toString() + " pts"

        firebaseDB.collection("app").document("quiz4").get().addOnSuccessListener {
            binding.tvUnidad4Tiempo.setText(it.get("tiempo") as String?)
        }

        binding.btnUnidad4Volver.setOnClickListener {
            startActivity(Intent(this, MenuPrincipal::class.java))
        }

        binding.btnUnidad4Comenzar.setOnClickListener {
            startActivity(Intent(this, Unidad4Quiz::class.java))
        }
    }
}