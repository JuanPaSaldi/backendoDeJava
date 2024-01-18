FROM maven:3.8.4-openjdk-17 as build

# Set the working directory in the Docker image
WORKDIR /app

# Copy the Maven wrapper (Unix Shell script) and pom.xml file to the image
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Ensure mvnw is executable
RUN chmod +x mvnw

# Install project dependencies
RUN ./mvnw dependency:go-offline

# Copy the project source
COPY src src

# Build the application without running tests
RUN ./mvnw package -DskipTests

# Step 2: Use a smaller base image to run the application
FROM openjdk:17-slim

# Set the working directory in the runtime image
WORKDIR /app

# Copy the built jar file from the build stage to the current stage
COPY --from=build /app/target/microservicios.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "app.jar"]
