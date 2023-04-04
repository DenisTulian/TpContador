package com.example.tpcontador.contract

interface CounterContract {
    interface View {
        fun updateCounterValue(counterValue: String)
        fun showErrorMessage()
    }

    interface Presenter {
        fun incrementCounter()
        fun decrementCounter()
        fun resetCounter()
    }

    interface Model {
        fun incrementCounterValue(value: Int)
        fun decrementCounterValue(value: Int)
        fun resetCounterValue()
        fun getCounterValue(): Int
    }
}
