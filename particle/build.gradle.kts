import com.thoughtworks.ark.androidLibrary
        import com.thoughtworks.ark.enableCompose

        @Suppress("DSL_SCOPE_VIOLATION")
        plugins {
            alias(libs.plugins.library)
            alias(libs.plugins.kotlin)
        }

apply(from = "../config/jacoco/modules.kts")

androidLibrary {
    enableCompose()
}

dependencies {
    implementation(project(":core"))
    implementation(libs.core.ktx)
    implementation(libs.material)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.kotlin)
    implementation(libs.router)
    implementation(libs.bundles.retrofit)
    implementation(libs.wire)
    implementation(libs.wire)
    testImplementation(libs.junit4)
}
