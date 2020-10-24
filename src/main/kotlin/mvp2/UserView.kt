package mvp2

import model.UserInfo


interface UserView {

    fun showUsers(users: List<UserInfo>)

    fun showUser(user: UserInfo)

    fun loadingState(isLoading: Boolean)

    fun showError(mes: String)
}


class UserViewImpl : UserView {

    override fun showUsers(users: List<UserInfo>) {
        printLine()
        println("||\tName\t||\tAge\t||")
        users.forEach { user ->
            printLine2()
            println(user)
        }
        printLine()
    }

    override fun showUser(user: UserInfo) {
        printLine()
        println("||\tName\t||\tAge\t||")
        printLine2()
        println(user)
        printLine()
    }

    override fun loadingState(isLoading: Boolean) {
        if (isLoading) {
            println("\tStart\tLoading")
        } else {
            println("\tDone\tLoading")
        }
    }

    override fun showError(mes: String) {
        System.err.println("Error : $mes")
    }

    private fun printLine() {
        println("===================================")
    }
    private fun printLine2() {
        println("-----------------------------------")
    }
}