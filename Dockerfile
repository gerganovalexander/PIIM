FROM amazoncorretto:17-alpine-jdk

COPY target/PIIM-0.0.1-SNAPSHOT.jar my-app.jar

ENTRYPOINT ["java", "-jar","my-app.jar"]

EXPOSE 8080