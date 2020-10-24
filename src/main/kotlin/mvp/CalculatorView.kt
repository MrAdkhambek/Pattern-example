package mvp


interface CalculatorView {

    fun showResult(mes: String)

    fun showError(mes: String)
}

class CalculatorViewImpl : CalculatorView {

    override fun showResult(mes: String) {
        println("Result : $mes")
    }

    override fun showError(mes: String) {
        System.err.println("Error : $mes")
    }
}