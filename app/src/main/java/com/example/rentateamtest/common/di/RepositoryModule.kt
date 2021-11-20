package com.example.rentateamtest.common.di

import com.example.rentateamtest.data.network.repository.UsersRepositoryImpl
import com.example.rentateamtest.domain.repository.UsersRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindUsersRepository(usersRepositoryImpl: UsersRepositoryImpl): UsersRepository
}