package com.jk.mytaxi

import android.app.Application
import com.jk.mytaxi.test1.di.component.AppComponent
import com.jk.mytaxi.test1.di.component.DaggerAppComponent
import com.jk.mytaxi.test1.di.module.NetworkModule

class TaxiApplication : Application() {


    companion object {
        lateinit var appComponent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()


    }
}