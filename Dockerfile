FROM tomcat
FROM openjdk:8
ENV MYSQL_URL=jdbc:mysql://dbserver:3306/SpeMajordb MYSQL_USER=root MYSQL_PASSWORD=root
COPY ./target/SpeMajor-backend-0.0.1-SNAPSHOT-jar-with-dependencies.jar /usr/local/tomcat/webapps
