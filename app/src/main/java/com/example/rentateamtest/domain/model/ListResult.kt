package com.example.rentateamtest.domain.model

data class ListResult<T>(
    val data: List<T>,
    val page: Int,
    val total: Int,
    val perPage: Int,
    val totalPages: Int,
)