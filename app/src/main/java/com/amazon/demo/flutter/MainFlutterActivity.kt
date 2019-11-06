package com.amazon.demo.flutter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import io.flutter.app.FlutterActivity
import io.flutter.plugins.GeneratedPluginRegistrant
import io.flutter.view.FlutterView

const val EXTRA_ROUTE = "route"

class MainFlutterActivity : FlutterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegistrant.registerWith(this)
        flutterView.enableTransparentBackground()
    }

    override fun createFlutterView(context: Context): FlutterView {
        val route = intent.getStringExtra(EXTRA_ROUTE) ?: ""
        val flutterView: FlutterView
        if (route.isNotBlank()) {
            flutterView = createRoutedFlutterView(route)
            this.setContentView(flutterView)
        } else {
            flutterView = super.createFlutterView(context)
        }
        return flutterView
    }

    private fun createRoutedFlutterView(route: String): FlutterView {
        val nativeView = createFlutterNativeView()
        return FlutterView(this, null, nativeView).apply {
            setInitialRoute(route)
            layoutParams = WindowManager.LayoutParams(-1, -1)
        }
    }

    companion object {

        @JvmStatic
        fun createIntent(context: Context, route: String) = Intent(context, MainFlutterActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            putExtra(EXTRA_ROUTE, route)
        }
    }
}
