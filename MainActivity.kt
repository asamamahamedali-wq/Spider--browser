package com.osama.spiderbrowser

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

/**
 * PH-00 proof-of-capability shell.
 * This is intentionally not the production browser implementation.
 * Browser, downloads, privacy and AI modules are documented and gated for later phases.
 */
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.rgb(16, 24, 39)
        window.navigationBarColor = Color.rgb(16, 24, 39)

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(12, 18, 31))
        }

        val title = TextView(this).apply {
            text = "SPIDER BROWSER"
            textSize = 28f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }
        val subtitle = TextView(this).apply {
            text = "PH-00 • Cloud Build Proof of Capability"
            textSize = 14f
            setTextColor(Color.rgb(87, 214, 197))
            gravity = Gravity.CENTER
            setPadding(0, 14, 0, 18)
        }
        val note = TextView(this).apply {
            text = "تم تشغيل الهيكل التجريبي بنجاح إذا ظهرت هذه الشاشة.\nلم تُنفّذ بعد وظائف التصفح أو التنزيل أو الذكاء الاصطناعي."
            textSize = 16f
            setTextColor(Color.rgb(220, 228, 240))
            gravity = Gravity.CENTER
            setLineSpacing(5f, 1f)
        }
        page.addView(title, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        page.addView(subtitle, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        page.addView(note, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        setContentView(page)
    }
}
