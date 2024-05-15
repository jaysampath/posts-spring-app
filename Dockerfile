FROM mysql:8.0

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=your_database_name

ENTRYPOINT [ "mysqld", "-u", "root", "-p$MYSQL_ROOT_PASSWORD" ]

# New stage for building Spring Boot app (optional, can be combined with MySQL stage)
FROM maven:3.8-jdk-alpine

WORKDIR /app

COPY app/pom.xml .
RUN mvn clean package

COPY app/target/*.jar app.jar

# Final stage (can combine builder and MySQL stages)
FROM openjdk:17-jdk-alpine

COPY app.jar /app

EXPOSE 8080  # Expose Spring Boot app port
EXPOSE 3306  # Expose MySQL port (optional for external access)

CMD [ "java", "-jar", "app.jar" ]
