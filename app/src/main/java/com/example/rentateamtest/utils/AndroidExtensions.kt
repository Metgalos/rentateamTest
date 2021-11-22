package com.example.rentateamtest.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.rentateamtest.App
import com.example.rentateamtest.common.di.AppComponent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }

fun ImageView.load(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}
