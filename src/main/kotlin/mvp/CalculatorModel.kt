package mvp


interface CalculatorModel {
    fun plus(a: Int, b: Int): Int
    fun minus(a: Int, b: Int): Int

    fun div(a: Int, b: Int): Int
    fun times(a: Int, b: Int): Int
}

class CalculatorModelImpl : CalculatorModel {

    override fun plus(a: Int, b: Int): Int = a + b

    override fun minus(a: Int, b: Int): Int = a - b

    override fun div(a: Int, b: Int): Int = a / b

    override fun times(a: Int, b: Int): Int = a * b
}