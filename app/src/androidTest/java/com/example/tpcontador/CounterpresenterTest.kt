package com.example.tpcontador

import org.junit.Before
import org.junit.Test
import io.mockk.*
import io.mockk.impl.annotations.MockK
import com.example.tpcontador.presenter.Counterpresenter
import com.example.tpcontador.model.Countermodel
import com.example.tpcontador.contract.CounterContract
import android.widget.EditText


class CounterpresenterTest {

    @MockK(relaxed = true)
    lateinit var model: Countermodel

    @MockK(relaxed = true)
    private lateinit var view: CounterContract.View

    @MockK(relaxed = true)
    private lateinit var editText: EditText

    private lateinit var presenter: Counterpresenter

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        presenter = Counterpresenter(model, view, editText)
    }

    @Test
    fun `test incrementCounter`() {

        every { editText.text.toString() } returns "1"
        every { view.updateCounterValue(any()) } just Runs
        every { model.incrementCounterValue(any()) } just Runs


        presenter.incrementCounter()


        verify { view.updateCounterValue("1") }
        verify { model.incrementCounterValue(1) }
    }

    @Test
    fun `test decrementCounter`() {

        every { editText.text.toString() } returns "1"
        every { view.updateCounterValue(any()) } just Runs
        every { model.decrementCounterValue(any()) } just Runs


        presenter.decrementCounter()


        verify { view.updateCounterValue("1") }
        verify { model.decrementCounterValue(1) }
    }
}
