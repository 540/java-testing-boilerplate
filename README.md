# Java Testing boilerplate

This is a boilerplate ready to start working on programming good practices.

## Properties

Java version: 21

Gradle version: 8.11

Build project:
- ./gradlew build

  :warning: :warning: **Build will fail because of tests, this is done in purpose, have a look at them!**  

Adjust intelliJ:
- Adjust project seetings in File > Project Structure > Project
- Adjust gradle in Preferences > Gradle > Gradle JVM

---

- Get Java version:
  - java --version

- Update Java version:
  - Download the JDK (version 21 right now)

---

- Get current Gradle version:
    - ./gradlew --version
    
- Update Gradle version ([take in account project's Java version for compatibility](https://docs.gradle.org/current/userguide/compatibility.html)):
    - ./gradlew wrapper --gradle-version <gradle-version>