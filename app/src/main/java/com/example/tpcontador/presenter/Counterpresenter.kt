package com.example.tpcontador.presenter


import android.widget.EditText
import com.example.tpcontador.model.Countermodel
import com.example.tpcontador.contract.CounterContract

class Counterpresenter(private val model: Countermodel, private val view: CounterContract.View, private val editText: EditText) : CounterContract.Presenter {

    override fun incrementCounter() {
        try {
            val value = editText.text.toString().toInt()
            model.incrementCounterValue(value)
            view.updateCounterValue(model.getCounterValue().toString())
        } catch (e: NumberFormatException){
            view.showErrorMessage()
        }

    }

    override fun decrementCounter() {
        try {
            val value = editText.text.toString().toInt()
            model.decrementCounterValue(value)
            view.updateCounterValue(model.getCounterValue().toString())
        }catch (e: NumberFormatException){
            view.showErrorMessage()
        }

    }

    override fun resetCounter() {
        model.resetCounterValue()
        view.updateCounterValue(model.getCounterValue().toString())
    }
}







