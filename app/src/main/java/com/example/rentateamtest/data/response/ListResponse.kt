package com.example.rentateamtest.data.response

import com.google.gson.annotations.SerializedName

data class ListResponse<T>(
    val page: Int?,
    val total: Int?,
    val data: List<T>?,

    @SerializedName("per_page")
    val perPage: Int?,

    @SerializedName("total_pages")
    val totalPages: Int?,
)
