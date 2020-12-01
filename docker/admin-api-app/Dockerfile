FROM openjdk:11-jre
ADD ./target/arcx-0.0.1-SNAPSHOT.jar arcx.jar
EXPOSE 7100
CMD ["java","-Dspring.profiles.active=dev", "-jar","arcx.jar"]
