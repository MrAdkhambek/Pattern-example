import model.UserInfo
import mvp.*
import mvp2.*


fun main() {
    mainCalculator()
//    mainUser()
}


fun mainCalculator() {
    val model: CalculatorModel = CalculatorModelImpl()
    val view: CalculatorView = CalculatorViewImpl()
    val presenter: CalculatorPresenter = CalculatorPresenterImpl(view, model)

    presenter.div(5, 0)
}

fun mainUser() {
    val model: UserModel = UserModelCache()

    val view: UserView = UserViewImpl()
    val presenter: UserPresenter = UserPresenterImpl(view, model)

    val adam = UserInfo("Adam", 22)
    val peter = UserInfo("Peter", 25)

    presenter.saveUser(adam)
    presenter.saveUser(peter)

    presenter.loadAndShowUsers()
}