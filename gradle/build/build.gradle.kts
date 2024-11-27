plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("com.codeborne:selenide:6.19.1")// Selenide
}

tasks.test {
    useJUnitPlatform()
}

