package mvp

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class TestCalculatorModel {

    private lateinit var model: CalculatorModel

    @Before
    fun onStart() {
        model = CalculatorModelImpl()
    }

    @Test
    fun plusTest() {
        val result: Int = model.plus(5, 9)
        assertEquals(result, 14)
    }

    @Test
    fun minusTest() {
        val result: Int = model.minus(5, 1)
        assertEquals(result, 4)
    }

    @Test
    fun divTest() {
        val result: Int = model.div(8, 4)
        assertEquals(result, 2)
    }

    @Test
    fun timesTest() {
        val result: Int = model.times(5, 5)
        assertEquals(result, 24)
    }
}