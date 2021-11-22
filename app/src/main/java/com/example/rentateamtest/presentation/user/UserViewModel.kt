package com.example.rentateamtest.presentation.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentateamtest.domain.model.User
import com.example.rentateamtest.domain.repository.UsersRepository
import com.example.rentateamtest.presentation.common.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: UsersRepository,
) : BaseViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getUser(id: Int) {
        disposables + repository.getUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _user.value = it
            }, {
                Log.e("UserViewModel", it.localizedMessage ?: "", it)
            })
    }
}