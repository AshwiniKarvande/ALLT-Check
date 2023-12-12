package org.pravin.alltcheck

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //createNotificationChannel()
    }

    private fun createNotificationChannel() {
        TODO("Not yet implemented")
    }
}