package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasosmetodosnumericos.databinding.ActivityMenuPrincipalBinding
import com.google.firebase.firestore.FirebaseFirestore

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
            binding.tvMenuPrincipalPuntuacion.setText(it.get("puntuacion") as String? + " pts")
            binding.tvMenuPrincipalPruebasContestadas.setText(it.get("tests") as String?)
            binding.tvMenuPrinipalUnidad1Puntuacion.setText(it.get("unit1puntuacion") as String? + " pts")
            binding.tvMenuPrinipalUnidad1Realizado.setText(it.get("unit1") as String?)
            binding.tvMenuPrinipalUnidad2Puntuacion.setText(it.get("unit2puntuacion") as String? + " pts")
            binding.tvMenuPrinipalUnidad2Realizado.setText(it.get("unit2") as String?)
            binding.tvMenuPrinipalUnidad3Puntuacion.setText(it.get("unit3puntuacion") as String? + " pts")
            binding.tvMenuPrinipalUnidad3Realizado.setText(it.get("unit3") as String?)
            binding.tvMenuPrinipalUnidad4Puntuacion.setText(it.get("unit4puntuacion") as String? + " pts")
            binding.tvMenuPrinipalUnidad4Realizado.setText(it.get("unit4") as String?)
            binding.tvMenuPrinipalUnidad5Puntuacion.setText(it.get("unit5puntuacion") as String? + " pts")
            binding.tvMenuPrinipalUnidad5Realizado.setText(it.get("unit5") as String?)
            binding.tvMenuPrinipalUnidad6Puntuacion.setText(it.get("unit6puntuacion") as String? + " pts")
            binding.tvMenuPrinipalUnidad6Realizado.setText(it.get("unit6") as String?)
        }

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