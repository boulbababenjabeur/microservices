FROM openjdk:8
EXPOSE 8088
ADD /target/demoReclamation-0.0.1-SNAPSHOT.jar demoReclamation.jar
ENTRYPOINT ["java", "-jar", "demoReclamation.jar"]