package com.example.rentateamtest.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentateamtest.domain.repository.UsersRepository
import javax.inject.Inject

class UserViewModelFactory @Inject constructor(
    private val repository: UsersRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (!modelClass.isAssignableFrom(UserViewModel::class.java)) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return UserViewModel(repository) as T
    }
}