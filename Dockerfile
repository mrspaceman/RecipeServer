#FROM openjdk:11-jdk
FROM eclipse-temurin:17
LABEL org.opencontainers.image.authors="Andy Aspell-Clark andyaspellclark@gmail.com"

ARG EXPOSED_PORT=80

RUN apt-get update -y && \
    apt-get upgrade -y && \
    apt-get install -y pydf htop fontconfig && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ARG JAR_FILE=target/recipeserver-0.0.1-SNAPSHOT.jar

CMD ["echo", "${JAR_FILE}"]
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
