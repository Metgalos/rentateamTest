package com.example.rentateamtest.data.network

import com.example.rentateamtest.BuildConfig
import com.example.rentateamtest.data.model.UserResponse
import com.example.rentateamtest.data.response.ListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApiService {

    @GET("/users")
    fun getUsers(@Query("page") page: Int = 1): Single<ListResponse<UserResponse>>

    companion object {
        const val BASE_URL = BuildConfig.USER_API_HOST
    }
}