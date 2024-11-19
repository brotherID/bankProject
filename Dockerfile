FROM openjdk:17-alpine
RUN mkdir /opt/app
COPY /target/file-exchange-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 9090
CMD ["java", "-jar", "/opt/app/file-exchange-0.0.1-SNAPSHOT.jar"]