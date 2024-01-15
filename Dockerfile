# Use the official OpenJDK 17 base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app .

# Copy the JAR file into the container
COPY /target/game_engine*.jar /app/.

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "game_engine*.jar"]