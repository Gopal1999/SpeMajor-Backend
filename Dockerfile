FROM openjdk:11
EXPOSE 8081
COPY ./target/SpeMajor-backend-0.0.1-SNAPSHOT.war ./
WORKDIR ./
FROM logstash:7.16.2
ENTRYPOINT ["java", "-jar", "SpeMajor-backend-0.0.1-SNAPSHOT.war"]
