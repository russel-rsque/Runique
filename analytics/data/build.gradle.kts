plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.rosique.analytics.data"
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.database)
    implementation(projects.analytics.domain)
}