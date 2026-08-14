FROM eclipse-temurin:25-jre
ADD target/userservice.jar userservice.jar
ENTRYPOINT [ "java","-jar","userservice.jar" ]
EXPOSE 8080