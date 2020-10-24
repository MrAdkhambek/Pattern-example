package mvp


interface CalculatorPresenter {

    fun plus(a: Int, b: Int)
    fun minus(a: Int, b: Int)

    fun div(a: Int, b: Int)
    fun times(a: Int, b: Int)
}


class CalculatorPresenterImpl(
    private val view: CalculatorView,
    private val model: CalculatorModel
) : CalculatorPresenter {

    override fun plus(a: Int, b: Int) {
        val result: Int = model.plus(a, b)
        view.showResult(result.toString())
    }

    override fun minus(a: Int, b: Int) {
        val result: Int = model.minus(a, b)
        view.showResult(result.toString())
    }

    override fun div(a: Int, b: Int) {
        try {
            val result: Int = model.div(a, b)
            view.showResult(result.toString())
        } catch (e: Exception) {
            view.showError("Some error")
        }
    }

    override fun times(a: Int, b: Int) {
        val result: Int = model.times(a, b)
        view.showResult(result.toString())
    }
}