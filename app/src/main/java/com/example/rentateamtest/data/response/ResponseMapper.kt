package com.example.rentateamtest.data.response

import com.example.rentateamtest.data.model.UserResponse
import com.example.rentateamtest.domain.model.ListResult
import com.example.rentateamtest.domain.model.User
import javax.inject.Inject

class ResponseMapper @Inject constructor() {

    fun mapUserListResponse(response: ListResponse<UserResponse>): ListResult<User> {
        val data = response.data?.map { mapUserResponse(it) } ?: emptyList()
        val size = data.size
        return ListResult(
            data = data,
            page = response.page ?: 1,
            total = response.total ?: size,
            perPage = response.perPage ?: size,
            totalPages = response.totalPages ?: 1,
        )
    }

    fun mapUserResponse(response: UserResponse): User {
        return User(
            id = response.id ?: 0,
            email = response.email ?: EMPTY_STRING_FIELD,
            avatarUrl = response.avatarUrl ?: "",
            firstName = response.firstName ?: EMPTY_STRING_FIELD,
            lastName = response.lastName ?: EMPTY_STRING_FIELD,
        )
    }

    companion object {
        private const val EMPTY_STRING_FIELD = "-"
    }
}