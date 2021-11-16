package com.szareckii.movieschart.ui

import android.app.Application
import com.szareckii.movieschart.di.AppComponent
import com.szareckii.movieschart.di.DaggerAppComponent
import com.szareckii.movieschart.di.modules.AppModule

class App: Application() {
    companion object{
        lateinit var instance: App
        val component get() = instance._appComponent
    }

    private lateinit var _appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        _appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}