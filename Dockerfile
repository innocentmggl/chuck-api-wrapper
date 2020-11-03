FROM openjdk:8
ADD target/jokes-app.jar app.jar
EXPOSE 9090
ENTRYPOINT [ "java", "-jar", "/app.jar" ]