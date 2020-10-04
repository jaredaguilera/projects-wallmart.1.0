FROM openjdk:8-jdk-slim
VOLUME /tmp
EXPOSE 8888
ADD /target/projectsWallmart.1.0.jar projectsWallmart.1.0.jar
ENTRYPOINT ["java","-jar","/projectsWallmart.1.0.jar"]