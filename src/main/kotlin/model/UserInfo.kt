package model

private var lastUserID = 0

data class UserInfo(
    val userName: String,
    val userAge: Int
) {
    val id: Int = ++lastUserID

    override fun toString(): String {
        return "||\t$userName\t||\t$userAge\t||"
    }
}