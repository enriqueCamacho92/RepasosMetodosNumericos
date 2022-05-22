package com.example.repasosmetodosnumericos

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad3QuizBinding
import com.google.firebase.firestore.FirebaseFirestore

class Unidad3Quiz : AppCompatActivity(), View.OnClickListener {
    var score=0
    var preguntasTotales=Unidad3PreguntasRespuestas.preguntas.size
    var preguntaActualIndice = 0
    var respuestaSeleccionada = ""
    private lateinit var binding: ActivityUnidad3QuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnidad3QuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRespuestaA.setOnClickListener(this)
        binding.btnRespuestaB.setOnClickListener(this)
        binding.btnRespuestaC.setOnClickListener(this)
        binding.btnRespuestaD.setOnClickListener(this)
        binding.btnSubmmitQuiz.setOnClickListener(this)

        binding.tvPreguntasTotales.setText("Preguntas totales: "+preguntasTotales)
        cargarNuevaPregunta();
    }

    override fun onClick(p0: View?) {
        binding.btnRespuestaA.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
        binding.btnRespuestaB.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
        binding.btnRespuestaC.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
        binding.btnRespuestaD.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
        var clickedButton: Button = p0 as Button
        if (clickedButton.id ==R.id.btnSubmmitQuiz){
            if(respuestaSeleccionada.equals(Unidad3PreguntasRespuestas.respuestasCorrectas[preguntaActualIndice])){
                score++
                Toast.makeText(this,"Correcto!", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Incorrecto, la respuesta es: "+Unidad3PreguntasRespuestas.respuestasCorrectas[preguntaActualIndice],Toast.LENGTH_SHORT).show()
            }
            preguntaActualIndice++
            cargarNuevaPregunta()
        }else{
            respuestaSeleccionada = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.MAGENTA)
        }
    }

    fun cargarNuevaPregunta(){
        if (preguntaActualIndice==preguntasTotales){
            terminarQuiz()
            return
        }
        binding.ivPregunta.setBackgroundResource(Unidad3PreguntasRespuestas.preguntas[preguntaActualIndice])
        binding.btnRespuestaA.setText(Unidad3PreguntasRespuestas.opciones[preguntaActualIndice][0])
        binding.btnRespuestaB.setText(Unidad3PreguntasRespuestas.opciones[preguntaActualIndice][1])
        binding.btnRespuestaC.setText(Unidad3PreguntasRespuestas.opciones[preguntaActualIndice][2])
        binding.btnRespuestaD.setText(Unidad3PreguntasRespuestas.opciones[preguntaActualIndice][3])
    }

    fun terminarQuiz(){
        var pasarStatus = ""
        if(score>preguntasTotales*0.60){
            pasarStatus = "Pasaste"
            quiz3="Si"
        }
        else{
            pasarStatus = "Reprobaste"
        }
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle(pasarStatus).setMessage("Aciertos: "+score+" de "+preguntasTotales)
            .setPositiveButton("Terminar", DialogInterface.OnClickListener { dialogInterface, i -> salir() })
            .setCancelable(false).show()
    }

    fun salir(){
        quiz3Score=(score*20).toFloat()
        pruebasContestadas++
        //Reiniciar Variables
        score=0
        preguntaActualIndice=0
        startActivity(Intent(this, Unidad3Inicio::class.java))
    }
}