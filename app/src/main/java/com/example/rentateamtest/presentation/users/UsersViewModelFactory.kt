package com.example.rentateamtest.presentation.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentateamtest.domain.repository.UsersRepository
import javax.inject.Inject

class UsersViewModelFactory @Inject constructor(
    private val repository: UsersRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (!modelClass.isAssignableFrom(UsersViewModel::class.java)) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return UsersViewModel(repository) as T
    }
}