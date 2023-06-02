FROM amazoncorretto:17-alpine-jdk
MAINTAINER JFR                                                                        
COPY  target/primer-proyecto-0.0.1-SNAPSHOT.jar jfr-app.jar
ENTRYPOINT  ["java","-jar","/jfr-app.jar"]                     