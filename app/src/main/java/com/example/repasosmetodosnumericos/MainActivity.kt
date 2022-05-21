package com.example.repasosmetodosnumericos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

lateinit var actualUserEmail: String

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Arrancar la aplicación en el LogIn
        startActivity(Intent(this, LogIn::class.java))
    }
}