FROM eclipse-temurin:21-jdk-alpine
LABEL authors = "andreas"
WORKDIR /app

COPY target/produit.jar ./produit.jar

EXPOSE 8089


CMD ["java", "-jar","produit.jar"]

