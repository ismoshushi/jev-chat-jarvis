package com.jev.probe

import android.app.Application
import android.content.Context

/**
 * Application entry. Firebase Analytics initializes itself via its
 * ContentProvider before this runs; we only keep a process-wide context
 * around so Analytics can obtain its instance lazily.
 */
class JevApp : Application() {

    override fun onCreate() {
        super.onCreate()
        JevAppContextHolder.appContext = applicationContext
    }
}

object JevAppContextHolder {
    lateinit var appContext: Context
        internal set
}
