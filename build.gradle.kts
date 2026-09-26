// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.7.3" apply false
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
    // Google services plugin: reads app/google-services.json and injects the
    // Firebase config at build time. Replace the placeholder json with the real
    // one from the Firebase console before making a public release.
    id("com.google.gms.google-services") version "4.4.2" apply false
}
