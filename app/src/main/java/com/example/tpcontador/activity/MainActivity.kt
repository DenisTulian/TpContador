package com.example.tpcontador.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.tpcontador.presenter.Counterpresenter
import com.example.tpcontador.R
import com.example.tpcontador.model.Countermodel
import com.example.tpcontador.contract.CounterContract
import android.widget.TextView
import android.widget.Toast
import com.example.tpcontador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContract.View {

    private lateinit var counterTextView: TextView
    private lateinit var counterEditText: EditText
    private lateinit var presenter: CounterContract.Presenter
    private lateinit var resetButton: Button
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        // Obtener referencias a los elementos de la interfaz
        counterTextView = findViewById(R.id.counterTextView)
        counterEditText = findViewById(R.id.tvCounterValue)
        val incrementButton = findViewById<Button>(R.id.btnIncrement)
        val decrementButton = findViewById<Button>(R.id.btnDecrement)
        resetButton = findViewById(R.id.btnReset)

        // Crear el presenter y asociarlo a la vista
        val model = Countermodel()
        presenter = Counterpresenter(model, this, counterEditText)

        // Asociar el listener del botón de incrementar
        incrementButton.setOnClickListener {
            try {
                counterEditText.text.toString().toIntOrNull() ?: 1
                presenter.incrementCounter()
            } catch (e: NumberFormatException){
                showErrorMessage()
            }
        }

        // Asociar el listener del botón de decrementar
        decrementButton.setOnClickListener {
            try {
                counterEditText.text.toString().toIntOrNull() ?: 1
                presenter.decrementCounter()
            } catch (e: NumberFormatException){
                showErrorMessage()
            }
        }

        // Asociar el listener del botón de resetear
        resetButton.setOnClickListener {
            presenter.resetCounter()
        }

        // que "ingrese el valor" desaparezca cuando toco el edit text en mi celular tuve que tocar 2 veces para que desaparezca
        counterEditText.setOnClickListener {
            counterEditText.setText("")
        }
    }

    override fun updateCounterValue(counterValue: String) {
        counterTextView.text = counterValue
    }

    override fun showErrorMessage() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT).show()
    }
}



