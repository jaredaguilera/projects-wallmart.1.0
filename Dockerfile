FROM ubuntu
RUN apt-get update
RUN apt-get -y install maven
WORKDIR /home
COPY . /home/app
WORKDIR /home/app
RUN mvn clean install
EXPOSE 8888
RUN java -jar ./target/projectsWallmart.1.0.jar
