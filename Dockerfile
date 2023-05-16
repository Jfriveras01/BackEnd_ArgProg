
FROM amazoncorretto:17-alpine-jdk                                
MAINTAINER FRIVERAS                                                
COPY  target/primer-proyecto-0.0.1-SNAPSHOT.jar fr-app.jar     
ENTRYPOINT  ["java","-jar","/fr-app.jar"]                     