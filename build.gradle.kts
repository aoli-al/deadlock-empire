plugins {
  id("java")
  id("org.pastalab.fray.gradle") version "0.3.1"
}

group = "org.pastalab.deadlockempire"

repositories {
  mavenCentral()
  mavenLocal()
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
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
