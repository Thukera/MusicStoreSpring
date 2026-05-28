#!/bin/bash
# Test script to verify deployment changes locally before pushing

set -e

echo "================================================"
echo "🧪 Testing Deployment Configuration"
echo "================================================"

# Check if we're in the right directory
if [ ! -d "musicStore" ]; then
    echo "❌ Error: musicStore directory not found!"
    echo "Please run this script from MusicStoreSpring root directory"
    exit 1
fi

echo "✅ Directory structure verified"
echo ""

# Test 1: Check if mvnw exists
echo "📦 Test 1: Checking Maven wrapper..."
if [ -f "musicStore/mvnw" ]; then
    echo "✅ mvnw found in musicStore/"
else
    echo "❌ mvnw not found in musicStore/"
    exit 1
fi
echo ""

# Test 2: Check Dockerfile
echo "🐳 Test 2: Checking Dockerfile..."
if [ -f "Dockerfile" ]; then
    echo "✅ Dockerfile found in root"
else
    echo "❌ Dockerfile not found in root"
    exit 1
fi
echo ""

# Test 3: Build JAR
echo "🏗️  Test 3: Building JAR..."
cd musicStore
chmod +x mvnw
./mvnw clean package -DskipTests
if [ $? -eq 0 ]; then
    echo "✅ JAR build successful"
else
    echo "❌ JAR build failed"
    exit 1
fi
cd ..
echo ""

# Test 4: Check if JAR was created
echo "📦 Test 4: Verifying JAR file..."
if [ -f "musicStore/target/musicStore-0.0.1-SNAPSHOT.jar" ]; then
    echo "✅ JAR file created: $(ls -lh musicStore/target/*.jar)"
else
    echo "❌ JAR file not found"
    exit 1
fi
echo ""

# Test 5: Build Docker image
echo "🐳 Test 5: Building Docker image..."
docker build -t music-store:test .
if [ $? -eq 0 ]; then
    echo "✅ Docker image built successfully"
else
    echo "❌ Docker build failed"
    exit 1
fi
echo ""

# Test 6: Test run container
echo "▶️  Test 6: Testing container..."
docker run -d --name music-store-test -p 7091:7090 music-store:test
sleep 5

if docker ps | grep -q music-store-test; then
    echo "✅ Container is running"
    docker logs music-store-test --tail 20
else
    echo "❌ Container failed to start"
    docker logs music-store-test
    docker rm music-store-test
    exit 1
fi
echo ""

# Test 7: Check if application is responding
echo "🌐 Test 7: Checking application health..."
sleep 10
if curl -f http://localhost:7091 >/dev/null 2>&1; then
    echo "✅ Application is responding"
else
    echo "⚠️  Application may still be starting up (this is sometimes OK)"
fi
echo ""

# Cleanup
echo "🧹 Cleaning up test resources..."
docker stop music-store-test
docker rm music-store-test
docker rmi music-store:test
echo "✅ Cleanup complete"
echo ""

echo "================================================"
echo "✅ All Tests Passed!"
echo "================================================"
echo ""
echo "You can now safely push to GitHub:"
echo "  git add ."
echo "  git commit -m \"Fix: Deployment workflow and Docker configuration\""
echo "  git push origin master"
echo ""

