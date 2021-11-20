package com.example.rentateamtest.utils

import android.content.Context
import com.example.rentateamtest.App
import com.example.rentateamtest.common.di.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }