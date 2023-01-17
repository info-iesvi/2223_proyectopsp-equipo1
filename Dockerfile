FROM openjdk:19
EXPOSE 8080
ARG JAR_FILE=target/2223_proyectopsp-equipo1-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]