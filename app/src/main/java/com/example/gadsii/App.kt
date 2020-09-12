package com.example.gadsii

import android.app.Application
import com.example.gadsii.ui.form.formModule
import com.example.gadsii.ui.main.pageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(pageModule, formModule))
        }
    }
}