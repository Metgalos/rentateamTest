package com.example.rentateamtest.domain.repository

import com.example.rentateamtest.domain.model.User
import io.reactivex.Single

interface UsersRepository {
    fun getUsers(): Single<List<User>>
    fun getUser(id: Int): Single<User>
}
