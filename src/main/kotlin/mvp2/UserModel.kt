package mvp2

import model.UserInfo


interface UserModel {

    fun loadAllUsers(): List<UserInfo>

    fun getUserById(id: Int): UserInfo

    fun saveUserInfo(userInfo: UserInfo)

    fun clear()
}


class UserModelCache : UserModel {

    private val dbUserInfo: MutableList<UserInfo> = arrayListOf()

    override fun loadAllUsers(): List<UserInfo> {
        return dbUserInfo
    }

    @Throws(KotlinNullPointerException::class)
    override fun getUserById(id: Int): UserInfo {
        return dbUserInfo.find {
            it.id == id
        } ?: throw KotlinNullPointerException("UserInfo not fount")
    }

    override fun saveUserInfo(userInfo: UserInfo) {
        dbUserInfo.add(userInfo)
    }

    override fun clear() {
        dbUserInfo.clear()
    }
}


class UserModelNetwork : UserModel {

    @Throws(NetworkException::class)
    override fun loadAllUsers(): List<UserInfo> {
        throw NetworkException("Not connect network")
    }

    @Throws(NetworkException::class)
    override fun getUserById(id: Int): UserInfo {
        throw NetworkException("Not connect network")
    }

    @Throws(NetworkException::class)
    override fun saveUserInfo(userInfo: UserInfo) {
        throw NetworkException("Not connect network")
    }

    @Throws(NetworkException::class)
    override fun clear() {
        throw NetworkException("Not connect network")
    }
}

class NetworkException(mes: String?) : Exception(mes)