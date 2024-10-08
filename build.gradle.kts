import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "no.nav.pgi"

val jacksonVersion = "2.17.2"

val junitJupiterVersion = "5.11.0"
val assertJVersion = "3.26.3"

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
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
    testImplementation(("org.assertj:assertj-core:$assertJVersion"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


release {
    git.requireBranch = "main"
    newVersionCommitMessage = "[Release Plugin] - next version commit: "
    tagTemplate = "release-\${version}"
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

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.10"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
