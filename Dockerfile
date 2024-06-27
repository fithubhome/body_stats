########################################################################################################################
#   OLD CONFIG                                                                                                         #
########################################################################################################################

##FROM amazoncorretto:17
##LABEL authors="rodilas"
#
## COPY PROJECT ARTIFACT TO CONTAINER:
##COPY target/random-backend-1.0-SNAPSHOT.jar app/random-backend.jar
#
## SET PROJECT EXECUTION COMMAND:
##ENTRYPOINT ["java", "-jar", "app/body-stats.jar"]
#
## BUILD IMAGE: docker build -t random_image .
## RUN CONTAINER: docker run -dp 9090:8080 --name random_container random_image
#
## Use the official Maven image to create a build stage with Java 17
#FROM maven:3.8.4-openjdk-17 AS build
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the project files to the working directory
#COPY pom.xml .
#COPY src ./src
#
## Package the application
#RUN mvn clean package -DskipTests
#
## Use the official OpenJDK image as the base image with Java 17
#FROM openjdk:17-slim
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the packaged jar file from the build stage
#COPY --from=build /app/target/body-stats-1.0-SNAPSHOT.jar app.jar
#
## Expose the application port
#EXPOSE 8095
#
## Run the application
#ENTRYPOINT ["java", "-jar", "app.jar"]

########################################################################################################################
#   NEW CONFIG                                                                                                         #
########################################################################################################################

FROM openjdk:17-jdk-alpine
COPY target/body-stats-1.0-SNAPSHOT.jar app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
