package com.amazon.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.amazon.demo.flutter.MainFlutterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stockCard.setOnClickListener { openFlutterActivity("stocks") }
        marketCard.setOnClickListener { openFlutterActivity("markets") }
    }

    // Initial Path
    private fun openFlutter(route: String) {

    }


    // Route 2 (workaround)
    private fun openFlutterActivity(route: String) {
        val intent = MainFlutterActivity.createIntent(this, route)
        startActivity(intent)
    }

}
