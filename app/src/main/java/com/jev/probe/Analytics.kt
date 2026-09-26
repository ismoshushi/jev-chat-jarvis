package com.jev.probe

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

/**
 * Thin wrapper around Firebase Analytics (Google Analytics for Firebase).
 *
 * Initialization itself is automatic: the Firebase SDK self-installs via a
 * ContentProvider once google-services.json is present, so no Application
 * class is needed. This wrapper only exists so that a telemetry failure can
 * never crash the app — every call is swallowed on error.
 *
 * Events currently logged:
 *  - screen views (logScreen) from the main entry activities
 *  - app_open / first_open are tracked automatically by the SDK
 */
object Analytics {

    private val analytics: FirebaseAnalytics? by lazy {
        try {
            FirebaseAnalytics.getInstance(JevAppContextHolder.appContext)
        } catch (_: Exception) {
            null
        }
    }

    fun logEvent(name: String, params: Bundle? = null) {
        try {
            analytics?.logEvent(name, params)
        } catch (_: Exception) {
            // Telemetry must never break the app.
        }
    }

    fun logScreen(screenName: String) {
        val params = Bundle().apply {
            putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
        }
        logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }

    fun setUserProperty(name: String, value: String) {
        try {
            analytics?.setUserProperty(name, value)
        } catch (_: Exception) {
        }
    }
}
