#!/bin/sh
./gradlew build
VERSION="0.0.3"
docker build -t user-service:$VERSION .