package com.example.rentateamtest.data.database

import com.example.rentateamtest.data.database.entity.UserDb
import com.example.rentateamtest.domain.model.User
import javax.inject.Inject

class DbMapper @Inject constructor() {

    fun mapListUserDbToUser(users: List<UserDb>): List<User> {
        return users.map { mapUserDbToUser(it) }
    }

    fun mapListUserToUserDb(users: List<User>): List<UserDb> {
        return users.map { mapUserToDb(it) }
    }

    fun mapUserToDb(user: User): UserDb {
        return UserDb(user.id, user.email, user.avatarUrl, user.firstName, user.lastName)
    }

    fun mapUserDbToUser(userDb: UserDb): User {
        return User(userDb.id, userDb.email, userDb.avatarUrl, userDb.firstName, userDb.lastName)
    }
}
