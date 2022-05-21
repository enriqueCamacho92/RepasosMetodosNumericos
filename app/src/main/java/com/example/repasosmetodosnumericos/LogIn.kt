package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.repasosmetodosnumericos.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth
import android.media.MediaPlayer

class LogIn : AppCompatActivity() {
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Solicitar Instancia en Firebase para Autenticación
        firebaseAuth = FirebaseAuth.getInstance()
        //Boton Registrarse
        binding.btnLogInRegistrarse.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }
        //Boton Acceder
        binding.btnLogInAcceder.setOnClickListener {
            val email = binding.etLogInCorreoElectronico.text.toString()
            val pass = binding.etLogInContrasena.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        actualUserEmail = email
                        startActivity(Intent(this, MenuPrincipal::class.java))
                    } else {
                        Toast.makeText(this,"Datos incorrectos", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"No se permiten campos vacíos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}