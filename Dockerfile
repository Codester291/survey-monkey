# Use the official OpenJDK image as the base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container to /app
WORKDIR /app

# Copy the JAR file from your host to /app in the container
COPY build/libs/surveymonkey-v1.jar /app/

# Command to run the application
CMD ["java", "-jar", "survey-monkey.jar"]