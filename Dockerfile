FROM openjdk:17
ADD target/proj.jar proj.jar
ENTRYPOINT ["java", "-jar", "/proj.jar"]