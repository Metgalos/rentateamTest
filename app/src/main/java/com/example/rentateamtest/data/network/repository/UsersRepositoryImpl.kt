package com.example.rentateamtest.data.network.repository

import com.example.rentateamtest.data.network.UsersApiService
import com.example.rentateamtest.data.response.ResponseMapper
import com.example.rentateamtest.domain.model.ListResult
import com.example.rentateamtest.domain.model.User
import com.example.rentateamtest.domain.repository.UsersRepository
import io.reactivex.Single
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val api: UsersApiService,
    private val mapper: ResponseMapper,
) : UsersRepository {

    override fun getUsers(page: Int): Single<ListResult<User>> {
        return api.getUsers(page).map { mapper.mapUserListResponse(it) }
    }
}
