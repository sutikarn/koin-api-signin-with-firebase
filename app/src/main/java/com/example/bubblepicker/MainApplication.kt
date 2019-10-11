package com.example.bubblepicker

import android.app.Application
import com.example.bubblepicker.Module.mainModule
import com.example.bubblepicker.Module.viewModelModule
import org.koin.android.ext.android.startKoin


class MainApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin (this,listOf(mainModule, viewModelModule),
            loadPropertiesFromFile = true)



    }
}