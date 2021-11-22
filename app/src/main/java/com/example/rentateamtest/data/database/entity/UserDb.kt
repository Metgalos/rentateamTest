package com.example.rentateamtest.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDb(
    @PrimaryKey val id: Int,
    val email: String,
    val avatarUrl: String,
    val firstName: String,
    val lastName: String,
) {
    fun isEmpty(): Boolean = id == 0

    companion object {
        fun createEmpty() = UserDb(0, "", "", "", "")
    }
}
