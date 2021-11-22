package com.example.rentateamtest.data.network

import com.example.rentateamtest.BuildConfig
import com.example.rentateamtest.data.response.UserBaseResponse
import com.example.rentateamtest.data.response.UsersBaseResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersApiService {

    @GET("users")
    fun getUsers(): Single<UsersBaseResponse>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Single<UserBaseResponse>

    companion object {
        const val BASE_URL = BuildConfig.USER_API_HOST
    }
}