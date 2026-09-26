package com.jev.probe

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

/**
 * In-app privacy policy page. Loads the bundled asset (assets/privacy.html),
 * so it opens instantly and works with no network at all — no external link.
 */
class PrivacyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val web = WebView(this)
        web.settings.javaScriptEnabled = false
        web.webViewClient = WebViewClient()
        setContentView(web)
        web.loadUrl("file:///android_asset/privacy.html")
    }
}
