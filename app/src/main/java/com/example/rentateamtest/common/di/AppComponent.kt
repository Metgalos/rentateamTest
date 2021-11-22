package com.example.rentateamtest.common.di

import com.example.rentateamtest.presentation.user.UserFragment
import com.example.rentateamtest.presentation.users.UsersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, NetworkModule::class, RepositoryModule::class])
interface AppComponent {
    fun inject(fragment: UsersFragment)
    fun inject(fragment: UserFragment)
}