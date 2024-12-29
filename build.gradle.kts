plugins {
    id("java")
}

group = "dev.keith"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

}

tasks.test {
    useJUnitPlatform()
}