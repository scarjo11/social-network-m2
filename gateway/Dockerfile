#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_IMAGE
#WORKDIR /tmp/
#COPY pom.xml /tmp/pom.xml
#COPY src /tmp/src
#RUN ["mvn", "package"]


FROM java:8-jre
COPY ./target/gateway-0.0.1-SNAPSHOT.jar /app/
#COPY wait-for-it.sh /app
#CMD ["cd", "/app", "&&", "./wait-for-it.sh", "config-server:8090"]
CMD ["java", "-Xmx200m", "-jar", "/app/gateway-0.0.1-SNAPSHOT.jar"]
EXPOSE 8095