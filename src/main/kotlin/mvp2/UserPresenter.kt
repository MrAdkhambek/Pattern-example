package mvp2

import model.UserInfo

interface UserPresenter {

    fun loadAndShowUsers()

    fun loadAndShowUserById(id: Int)

    fun saveUser(userInfo: UserInfo)
}

class UserPresenterImpl(
    private val view: UserView,
    private val model: UserModel
) : UserPresenter {

    override fun loadAndShowUsers() {
        view.loadingState(true)

        val users: List<UserInfo> = model.loadAllUsers()
        view.showUsers(users)

        view.loadingState(false)
    }

    override fun loadAndShowUserById(id: Int) {
        view.loadingState(true)
        try {
            val user: UserInfo = model.getUserById(id)
            view.showUser(user)
        } catch (e: NullPointerException) {
            view.showError(e.message ?: e.localizedMessage)
        } catch (e: Exception) {
            view.showError(e.message ?: e.localizedMessage)
        } finally {
            view.loadingState(false)
        }
    }

    override fun saveUser(userInfo: UserInfo) {
        model.saveUserInfo(userInfo)
    }

    private fun stateFunction(body: () -> Unit) {
        view.loadingState(true)
        try {
            body()
        } catch (e: NullPointerException) {
            view.showError(e.message ?: e.localizedMessage)
        } catch (e: NetworkException) {
            view.showError(e.message ?: e.localizedMessage)
        } catch (e: Exception) {
            view.showError(e.message ?: e.localizedMessage)
        } finally {
            view.loadingState(false)
        }
    }
}