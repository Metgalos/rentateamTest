package com.example.rentateamtest.domain.repository

import com.example.rentateamtest.domain.model.ListResult
import com.example.rentateamtest.domain.model.User
import io.reactivex.Single

interface UsersRepository {

    fun getUsers(page: Int = 1): Single<ListResult<User>>
}
