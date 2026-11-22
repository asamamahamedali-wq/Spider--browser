package com.osama.spiderbrowser

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = TextView(this).apply {
            text = "SPIDER BROWSER\n\nPH-00 — Build Environment Test\n\nتم تشغيل شاشة الاختبار الأولية بنجاح."
            textSize = 20f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(18, 24, 38))
        }

        setContentView(message)
    }
}
