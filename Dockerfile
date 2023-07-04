FROM openjdk:17
ADD target/proj-0.0.1-SNAPSHOT.jar proj-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/proj-0.0.1-SNAPSHOT.jar"]