# Utiliser une image Maven officielle
FROM maven:3.8.8-eclipse-temurin-21 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers nécessaires
COPY . .

# Construire le projet Maven
RUN mvn clean install

# Étape de production
FROM eclipse-temurin:21-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le jar généré depuis l'étape précédente
COPY --from=build /app/target/demo-1.0-SNAPSHOT.jar app.jar

# Exposer le port de l'application
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]