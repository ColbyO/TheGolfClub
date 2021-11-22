FROM openjdk:11-slim-bullseye

RUN apt-get update && apt-get -y upgrade && apt clean all

ADD target/backend-1.0.0-build.jar /app/backend.jar

ENTRYPOINT ["/bin/sh", "-c", "java $JAVA_OPTS -Dnetworkaddress.cahce.ttl=60 -Djava.security.egd=file:/dev/./urandom -jar /app/backend.jar"]

EXPOSE 8080:80