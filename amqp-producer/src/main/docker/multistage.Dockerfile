FROM quay.io/quarkus/centos-quarkus-maven:20.0.0-java11 AS build
COPY amqp-producer/pom.xml ./pom.xml
COPY amqp-producer/src/* src/
RUN ls -lh ./src
RUN mvn -Pnative package -DskipTests

FROM registry.access.redhat.com/ubi8/ubi-minimal
WORKDIR /work/
COPY --from=build /project/target/*-runner /work/application
RUN chmod 775 /work
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]