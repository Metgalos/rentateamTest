package com.example.rentateamtest.presentation.users

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentateamtest.domain.repository.UsersRepository
import com.example.rentateamtest.presentation.common.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersViewModel constructor(
    private val repository: UsersRepository,
) : BaseViewModel() {

    private val _state = MutableLiveData(UsersState())
    val state: LiveData<UsersState> = _state

    init {
        getUsers()
    }

    private fun getUsers() {
        _state.value?.let { _state.value = it.copy(isLoading = true) }
        disposables + repository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _state.value = state.value?.copy(isLoading = false, users = it)
            }, { throwable ->
                Log.e("UsersViewModel", "Users loading error", throwable)
                _state.value = state.value?.copy(
                    users = null,
                    error = "Loading error",
                    isLoading = false
                )
            })
    }
}