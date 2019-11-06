package com.amazon.demo

import android.app.Application
import io.flutter.facade.Flutter

class DemoStockApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Flutter.startInitialization(this)
    }
}