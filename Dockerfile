FROM openjdk:17
ADD target/proj.jar proj.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/proj.jar"]