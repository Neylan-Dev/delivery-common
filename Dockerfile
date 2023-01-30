# Use an openjdk 11 image as the base image
FROM openjdk:11

# Set the working directory
WORKDIR /app

# Copy the JAR file to the working directory
COPY target/delivery-common-1.0.0.jar /app/delivery-common-1.0.0.jar

EXPOSE 8081

# Run the application
CMD ["java", "-jar", "delivery-common-1.0.0.jar"]
