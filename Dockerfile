FROM tomcat
FROM openjdk:8
ENV MYSQL_URL=jdbc:mysql://backend-mysql/SpeMajordb MYSQL_USER=root MYSQL_PASSWORD=password
COPY ./target/SpeMajor-backend-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/local/tomcat/webapps
