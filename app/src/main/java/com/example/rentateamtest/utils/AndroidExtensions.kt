package com.example.rentateamtest.utils

import android.content.Context
import com.example.rentateamtest.App
import com.example.rentateamtest.common.di.AppComponent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }

operator fun CompositeDisposable.plus(d: Disposable): CompositeDisposable {
    add(d)
    return this
}
