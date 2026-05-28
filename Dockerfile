# Multi-stage build for Music Store Spring Boot Application
FROM eclipse-temurin:17-jdk-jammy AS build

# Set working directory
WORKDIR /build

# Copy the musicStore directory
COPY musicStore/ .

# Build the application
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-jammy

# Set working directory
WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /build/target/*.jar app.jar

# Create directories for volumes
RUN mkdir -p /app/uploads /app/logs

# Expose port
EXPOSE 7090

# Set JVM options
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD curl -f http://localhost:7090/actuator/health || exit 1

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

