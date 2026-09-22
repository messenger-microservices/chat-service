# Build Stage
FROM eclipse-temurin:25-jdk-jammy AS build

WORKDIR /app-build

COPY ./gradle/wrapper ./
COPY gradlew settings.gradle.kts gradle.properties ./

RUN ./gradlew dependencies --no-daemon

COPY build.gradle.kts ./
COPY ./gradle/libs.versions.toml ./gradle/libs.versions.toml

RUN ./gradlew bootJar -x test --no-daemon

# Execution Stage
FROM eclipse-temurin:25-jre-jammy AS execution

WORKDIR /app

COPY --from=build /app-build/build/libs/*.jar application.jar

EXPOSE 8003
ENTRYPOINT ["java", "-jar", "application.jar"]
