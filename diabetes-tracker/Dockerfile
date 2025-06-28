# Base image: Java 21 (Eclipse Temurin)
FROM eclipse-temurin:21-jdk-jammy

# İş qovluğu konteynerdə
WORKDIR /app

# Jar faylını konteynerə kopyala
COPY target/diabetes-tracker-0.0.1-SNAPSHOT.jar app.jar

# Portu aç (layihənin işlədiyi port)
EXPOSE 8080

# Konteyner başladanda bu komanda işə düşəcək
ENTRYPOINT ["java", "-jar", "app.jar"]
