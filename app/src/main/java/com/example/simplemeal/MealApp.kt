package com.example.simplemeal

import android.app.Application
import com.example.simplemeal.di.appModule
import com.example.simplemeal.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MealApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MealApp)
            modules(networkModule, appModule)
        }
    }
}