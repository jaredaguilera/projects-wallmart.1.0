FROM openjdk:8-jdk-slim
COPY "./target/projectsWallmart.1.0.jar" "app.jar"
EXPOSE 8080
CMD ["java","-jar","app.jar"]