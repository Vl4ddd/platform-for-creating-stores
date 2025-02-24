FROM openjdk:17-jdk-slim AS build

WORKDIR /app
COPY . .
RUN apt-get update && apt-get install -y maven
RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]