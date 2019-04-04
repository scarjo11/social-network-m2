#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_IMAGE
#WORKDIR /tmp/
#COPY pom.xml /tmp/pom.xml
#COPY src /tmp/src
#RUN ["mvn", "package"]


#FROM openjdk:8-jre-alpine
#COPY target/microservice-client-0.0.1-SNAPSHOT.jar /app/


#CMD ["java", "-Xmx200m", "-jar", "/app/microservice-client-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8085

FROM java:8-jre
COPY ./target/microservice-client-0.0.1-SNAPSHOT.jar /app/
#COPY wait-for-it.sh /app
#CMD ["cd", "/app", "&&", "./wait-for-it.sh", "config-server:8090"]
#ADD wait-for-it.sh /wait-for-it.sh
#RUN chmod +x /wait-for-it.sh
#ENTRYPOINT ["/wait-for-it.sh config-server:8090"]
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-client-0.0.1-SNAPSHOT.jar"]
EXPOSE 8085