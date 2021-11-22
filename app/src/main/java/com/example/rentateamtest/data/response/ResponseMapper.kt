package com.example.rentateamtest.data.response

import com.example.rentateamtest.data.model.UserResponse
import com.example.rentateamtest.domain.model.User
import com.google.gson.Gson
import javax.inject.Inject

class ResponseMapper @Inject constructor() {

    fun mapUserListResponse(response: UsersBaseResponse): List<User> {
        return response.data?.map { mapUserResponse(it) } ?: emptyList()
    }

    fun mapBaseUserResponse(response: UserBaseResponse): User {
        return mapUserResponse(response.data)
    }

    private fun mapUserResponse(response: UserResponse?): User {
        return User(
            id = response?.id ?: 0,
            email = response?.email ?: EMPTY_STRING_FIELD,
            avatarUrl = response?.avatarUrl ?: "",
            firstName = response?.firstName ?: EMPTY_STRING_FIELD,
            lastName = response?.lastName ?: EMPTY_STRING_FIELD,
        )
    }

    companion object {
        private const val EMPTY_STRING_FIELD = "-"
    }
}