plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.rosique.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}