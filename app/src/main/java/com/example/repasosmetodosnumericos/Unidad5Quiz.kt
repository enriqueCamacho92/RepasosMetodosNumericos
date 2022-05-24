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
import com.example.repasosmetodosnumericos.databinding.ActivityUnidad5QuizBinding

class Unidad5Quiz : AppCompatActivity(), View.OnClickListener {
    var score=0
    var preguntasTotales=Unidad5PreguntasRespuestas.preguntas.size
    var preguntaActualIndice = 0
    var respuestaSeleccionada = ""
    var list: MutableList<Int> = (0..4).toMutableList()
    var random: Boolean = false
    private lateinit var binding: ActivityUnidad5QuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnidad5QuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRespuestaA.setOnClickListener(this)
        binding.btnRespuestaB.setOnClickListener(this)
        binding.btnRespuestaC.setOnClickListener(this)
        binding.btnRespuestaD.setOnClickListener(this)
        binding.btnSubmmitQuiz.setOnClickListener(this)
        binding.tvPreguntasTotales.setText("Preguntas totales: "+preguntasTotales)
        if (random==false){randomizador()}
        cargarNuevaPregunta();
    }

    override fun onClick(p0: View?) {
        binding.btnRespuestaA.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
        binding.btnRespuestaB.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
        binding.btnRespuestaC.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
        binding.btnRespuestaD.setBackgroundColor(Color.parseColor("#FFFFEB3B"))
        var clickedButton: Button = p0 as Button
        if (clickedButton.id ==R.id.btnSubmmitQuiz){
            if(respuestaSeleccionada.equals(Unidad5PreguntasRespuestas.respuestasCorrectas[list[preguntaActualIndice]])){
                score++
                Toast.makeText(this,"Correcto!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Incorrecto, la respuesta es: "+Unidad5PreguntasRespuestas.respuestasCorrectas[list[preguntaActualIndice]],Toast.LENGTH_SHORT).show()
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
        binding.ivPregunta.setBackgroundResource(Unidad5PreguntasRespuestas.preguntas[list[preguntaActualIndice]])
        binding.btnRespuestaA.setText(Unidad5PreguntasRespuestas.opciones[list[preguntaActualIndice]][0])
        binding.btnRespuestaB.setText(Unidad5PreguntasRespuestas.opciones[list[preguntaActualIndice]][1])
        binding.btnRespuestaC.setText(Unidad5PreguntasRespuestas.opciones[list[preguntaActualIndice]][2])
        binding.btnRespuestaD.setText(Unidad5PreguntasRespuestas.opciones[list[preguntaActualIndice]][3])
    }

    fun terminarQuiz(){
        var pasarStatus = ""
        if(score>preguntasTotales*0.60){
            pasarStatus = "Pasaste"
            quiz5="Si"
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
        quiz5Score=(score*20).toFloat()
        pruebasContestadas++
        //Reiniciar Variables
        score=0
        preguntaActualIndice=0
        startActivity(Intent(this, Unidad5Inicio::class.java))
    }

    fun randomizador(){
        list.shuffle()
        random=true
    }
}