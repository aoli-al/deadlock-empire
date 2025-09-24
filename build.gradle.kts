plugins {
  id("java")
  id("org.pastalab.fray.gradle") version "0.6.7"
}

group = "org.pastalab.deadlockempire"

repositories {
  mavenCentral()
  mavenLocal()
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(23))
  }
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.10.0"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
  useJUnitPlatform()
  enabled = false
}
