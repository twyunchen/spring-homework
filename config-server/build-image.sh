#!/bin/sh
./gradlew build
VERSION="0.0.1"
docker build -t config-server:$VERSION .