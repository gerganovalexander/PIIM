FROM openjdk:17-jdk

COPY target/*.jar piim-app.jar

ENTRYPOINT ["java", "-jar","piim-app.jar"]

EXPOSE 8080