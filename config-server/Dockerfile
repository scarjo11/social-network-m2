#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_IMAGE
#WORKDIR /tmp/
#COPY pom.xml /tmp/pom.xml
#COPY src /tmp/src
#RUN ["mvn", "package"]


FROM java:8-jre
COPY  ./target/config-server-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/config-server-0.0.1-SNAPSHOT.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8090/actuator/health || exit 1
EXPOSE 8090