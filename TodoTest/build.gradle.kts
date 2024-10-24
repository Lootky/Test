plugins {
    kotlin("jvm") version "1.8.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
    testImplementation("org.junit.platform:junit-platform-launcher:1.9.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // HTTP клиент OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.9.3")

    // Jackson для работы с JSON
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")

    // WebSocket поддержка
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
}

tasks.test {
    useJUnitPlatform()
}
