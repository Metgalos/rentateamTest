package com.example.rentateamtest.domain.model

data class User(
    val id: Int,
    val email: String,
    val avatarUrl: String,
    val firstName: String,
    val lastName: String,
) {
    fun isEmpty(): Boolean = id == 0

    companion object {
        fun createEmpty() = User(0, "", "", "", "")
    }
}
