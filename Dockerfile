FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
ADD target/remind-me-1.0.jar remind-me-1.0.jar
ENTRYPOINT ["java","-jar","/remind-me-1.0.jar"]