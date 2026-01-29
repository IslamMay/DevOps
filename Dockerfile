# Image Java
FROM eclipse-temurin:17-jdk-alpine


# Copier le jar
COPY target/*.jar app.jar

# Exposer le port
EXPOSE 8083

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]