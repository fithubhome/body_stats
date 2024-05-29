FROM amazoncorretto:17
LABEL authors="rodilas"

# COPY PROJECT ARTIFACT TO CONTAINER:
COPY target/random-backend-1.0-SNAPSHOT.jar app/random-backend.jar

# SET PROJECT EXECUTION COMMAND:
ENTRYPOINT ["java", "-jar", "app/body-stats.jar"]

# BUILD IMAGE: docker build -t random_image .
# RUN CONTAINER: docker run -dp 9090:8080 --name random_container random_image