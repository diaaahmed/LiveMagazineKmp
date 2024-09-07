package com.livemagazine.livemagazinekmp

import android.app.Application
import com.livemagazine.livemagazinekmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication: Application()
{
    override fun onCreate() {
        super.onCreate()

        initKoin{
            androidContext(this@MainApplication)
        }
    }
}