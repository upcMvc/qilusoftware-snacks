#!/bin/bash

SERVER="115.159.153.43"
JAR="target/Qilu2016-0.0.1-SNAPSHOT.jar"
ROUTE="/home/springboot/qilu/"

echo "clean"
mvn clean
echo "Building $JAR..."
mvn package

echo "Upload $JAR to server $SERVER..."
scp $JAR root@$SERVER:$ROUTE

echo "upload config to server"
scp src/main/resources/application-production.yml root@$SERVER:$ROUTE

python deploy.py