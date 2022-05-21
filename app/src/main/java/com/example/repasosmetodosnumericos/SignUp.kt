package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.repasosmetodosnumericos.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignUp : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var firebaseDB : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDB = FirebaseFirestore.getInstance()
        //Boton Registrarse
        binding.btnSignUpRegistrarse.setOnClickListener {
            val email = binding.etSignUpCorreoElectronico.text.toString()
            val pass = binding.etSignUpContrasena.text.toString()
            val confirmPass = binding.etSignUpConfirmarContrasena.text.toString()
            val nombre = binding.etSignUpNombre.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass==confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener {
                            if(it.isSuccessful){
                                firebaseDB.collection("users").document(email).set(
                                    hashMapOf(
                                        "nombre" to nombre,
                                        "puntuacion" to "00.00",
                                        "tests" to "0",
                                        "unit1" to "No",
                                        "unit1puntuacion" to "00.00",
                                        "unit2" to "No",
                                        "unit2puntuacion" to "00.00",
                                        "unit3" to "No",
                                        "unit3puntuacion" to "00.00",
                                        "unit4" to "No",
                                        "unit4puntuacion" to "00.00",
                                        "unit5" to "No",
                                        "unit5puntuacion" to "00.00",
                                        "unit6" to "No",
                                        "unit6puntuacion" to "00.00",
                                    )
                                )
                                startActivity(Intent(this, LogIn::class.java))
                            }else{
                                Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                            }
                        }

                }else{
                    Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"No se permiten campos vacíos",Toast.LENGTH_SHORT).show()
            }
        }
    }
}