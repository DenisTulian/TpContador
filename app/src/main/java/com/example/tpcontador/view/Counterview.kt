package com.example.tpcontador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tpcontador.contract.CounterContract
import com.example.tpcontador.R
import android.widget.Toast

class Counterview : AppCompatActivity(), CounterContract.View {

    private lateinit var counterValue: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button

    private lateinit var presenter: CounterContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_counterview)

        //counterValue = findViewById(R.id.counter_value)
        incrementButton = findViewById(R.id.btnIncrement)
        decrementButton = findViewById(R.id.btnDecrement)

        //presenter = Counterpresenter(this)

        incrementButton.setOnClickListener {
            presenter.incrementCounter()
        }

        decrementButton.setOnClickListener {
            presenter.decrementCounter()
        }
    }

    override fun updateCounterValue(counterValue: String) {
        this.counterValue.text = counterValue
    }

    override fun showErrorMessage() {
        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
    }
}
