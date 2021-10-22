FROM openjdk:11-jdk
MAINTAINER Andy Aspell-Clark andyaspellclark@gmail.com

RUN apt install fontconfig

ARG JAR_FILE=target/recipeserver-0.0.1-SNAPSHOT.jar
CMD ["echo", "${JAR_FILE}"]
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
