package mvp2

import model.UserInfo
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class TestUserModelCache {

    private lateinit var model: UserModel

    @Before
    fun onStart() {
        model = UserModelCache()
    }

    @Test
    fun loadAllUsers() {
        val adam = UserInfo("Adam", 22)

        model.clear()
        model.saveUserInfo(adam)

        val users: List<UserInfo> = model.loadAllUsers()
        assertEquals(users, listOf(adam))
    }


    @Test
    fun getUserById() {
        val adam = UserInfo("Adam", 22)

        model.saveUserInfo(adam)

        val user: UserInfo = model.getUserById(adam.id)
        assertEquals(user, adam)
    }

    @Test
    fun saveUserInfo() {
        val adam = UserInfo("Adam", 22)

        model.clear()
        model.saveUserInfo(adam)
    }


    @Test
    fun clear() {
        val adam = UserInfo("Adam", 22)
        model.saveUserInfo(adam)
        model.clear()

        val users: List<UserInfo> = model.loadAllUsers()
        assertEquals(0, users.size)
    }
}


