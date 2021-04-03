package com.example.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = calcular
        val textResultado = texto_resultado

        btCalcular.setOnClickListener {
            val nota1 = Integer.parseInt(nota1.editText?.text.toString())
            val nota2 = Integer.parseInt(nota2.editText?.text.toString())
            val media = (nota1 + nota2) / 2
            val faltas = Integer.parseInt(faltas.editText?.text.toString())

            if(media >= 6  && faltas <= 10){
                textResultado.text = getString(R.string.resultado_aprovado,media,faltas)
                val corInt = ResourcesCompat.getColor(resources, R.color.green_900, null)
                resultado.setCardBackgroundColor(corInt)
            }else{
                textResultado.text = getString(R.string.resultado_reprovado,media,faltas)
                val corInt = ResourcesCompat.getColor(resources, R.color.red_900, null)
                resultado.setCardBackgroundColor(corInt)
            }
            resultado.isVisible = true
        }
    }
}