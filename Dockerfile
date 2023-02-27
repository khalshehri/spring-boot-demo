FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/demo.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]