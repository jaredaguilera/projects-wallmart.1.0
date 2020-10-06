FROM openjdk:8-jdk-slim
ARG JAR_FILE=target/projectsWallmart.1.0.jar
ADD ${JAR_FILE} "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]