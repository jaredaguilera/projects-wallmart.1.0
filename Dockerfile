FROM ubuntu
RUN apt-get update
RUN apt-get -y install maven
WORKDIR /home
COPY . /home/app
WORKDIR /home/app
RUN mvn clean install
RUN java -jar ./target/listener-0.0.1-SNAPSHOT.jar