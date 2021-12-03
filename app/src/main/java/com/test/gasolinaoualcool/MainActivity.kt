package com.test.gasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun calcularPreco (view: View){

        //RecuperarValores
        val precoAlcool = precoAlcool.text.toString()
        val precoGasolina = precoGasolina.text.toString()


        //Validar campos

        val validaCampos = validarCampos (precoAlcool, precoGasolina)
        if (validaCampos){
                calcularMelhorPreco ( precoAlcool, precoGasolina)
        }else{
            textResultado.text = "Preencha os campos primeiro!"
        }

    }

    fun calcularMelhorPreco (precoAlcool: String, precoGasolina: String){

        //Converter valores String para double
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /* Calculo alcool x gasolina ( preco alcool / precoGasolina )
                Se resultado >= 0.7, melhor utilizar gasolina,
                caso contrario melhor alcool.
         */
        val resultadoPreco = valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7){
            textResultado.text = "Melhor usar Gasolina"
        }else {
            textResultado.text = "Melhor usar Alcool"
        }

    }

    fun validarCampos (precoAlcool: String, precoGasolina: String): Boolean{

        var camposValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }

            return camposValidados

    }

}