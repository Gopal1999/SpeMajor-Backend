FROM openjdk:11
EXPOSE 8081
COPY ./target/SpeMajor-backend-0.0.1-SNAPSHOT.jar ./
WORKDIR ./
ENTRYPOINT ["java", "-jar", "SpeMajor-backend-0.0.1-SNAPSHOT.jar"]
