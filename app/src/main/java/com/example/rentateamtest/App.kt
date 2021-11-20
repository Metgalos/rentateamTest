package com.example.rentateamtest

import android.app.Application
import com.example.rentateamtest.common.di.AppComponent
import com.example.rentateamtest.common.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent = DaggerAppComponent.create()
}