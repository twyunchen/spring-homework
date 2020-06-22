#!/bin/sh
./gradlew build
VERSION="0.0.2"
docker build -t config-server:$VERSION .