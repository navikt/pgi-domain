val avroVersion = "1.10.0"

group = "no.nav.pgi"

repositories {
    mavenCentral()
    maven(url = "https://dl.bintray.com/gradle/gradle-plugins")
    maven(url = "https://packages.confluent.io/maven/")
}

plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.serialization") version "1.9.10"
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("net.researchgate.release") version "3.0.2"
    id("com.github.ben-manes.versions") version "0.51.0"
    `maven-publish`
    `java-library`
}

dependencies {
    implementation("org.apache.avro:avro:$avroVersion")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


release {
    git.requireBranch = "master"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/navikt/${rootProject.name}")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.10"
}
