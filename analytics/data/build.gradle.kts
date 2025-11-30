plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.rosique.analytics.data"
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)

    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.analytics.domain)
}