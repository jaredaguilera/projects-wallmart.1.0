FROM openjdk:8-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests

FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG APP_NAME
ARG DEPENDENCY=/workspace/app/target
ARG ARTIFACT_NAME
ENV APP_NAME=$APP_NAME
COPY --from=build /workspace/app/target/projectsWallmart.1.0.jar /app/projectsWallmart.jar
ENTRYPOINT ["java","-jar","/app/projectsWallmart.jar"]