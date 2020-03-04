package com.example.bubblepicker

import android.app.Application
import com.example.bubblepicker.Module.mainModule
import com.example.bubblepicker.Module.viewModelModule
import com.mohamadamin.kpreferences.base.KPreferenceManager
import org.koin.android.ext.android.startKoin


class MainApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        KPreferenceManager.initialize(this)
        startKoin (this,listOf(mainModule, viewModelModule),
            loadPropertiesFromFile = true)

    }
}