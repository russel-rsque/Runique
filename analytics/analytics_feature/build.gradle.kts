plugins {
    alias(libs.plugins.runique.android.dynamic.feature)
}
android {
    namespace = "com.rosique.analytics.analytics_feature"
}

dependencies {
    implementation(project(":app"))

    implementation(libs.androidx.navigation.compose)

    api(projects.analytics.presentation)
    implementation(projects.analytics.data)
    implementation(projects.analytics.domain)
    implementation(projects.core.database)
}