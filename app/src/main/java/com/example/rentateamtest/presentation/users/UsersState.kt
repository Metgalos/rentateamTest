package com.example.rentateamtest.presentation.users

import com.example.rentateamtest.domain.model.User

data class UsersState(
    val isLoading: Boolean = false,
    val users: List<User>? = null,
    val error: String? = null,
)