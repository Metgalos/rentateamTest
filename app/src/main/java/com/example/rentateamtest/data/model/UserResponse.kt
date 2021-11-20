package com.example.rentateamtest.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val id: Int?,
    val email: String?,

    @SerializedName("avatar")
    val avatarUrl: String?,

    @SerializedName("first_name")
    val firstName: String?,

    @SerializedName("last_name")
    val lastName: String?,
)
