package com.example.smokestalks

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SmokesAndTalksApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SmokesAndTalksApplication)
            modules(listOf(mainModule))
        }
    }
}
