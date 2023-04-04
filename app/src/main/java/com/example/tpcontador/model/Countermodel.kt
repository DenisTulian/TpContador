package com.example.tpcontador.model
import com.example.tpcontador.contract.CounterContract


class Countermodel : CounterContract.Model {

    private var counterValue = 0

    override fun incrementCounterValue(value: Int) {
        counterValue += value
    }

    override fun decrementCounterValue(value: Int) {
        counterValue -= value
    }

    override fun resetCounterValue() {
        counterValue = 0
    }

    override fun getCounterValue(): Int {
        return counterValue
    }
}


