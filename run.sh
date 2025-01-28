#!/bin/bash
docker run -it --rm -v "$PWD":/usr/src/mymaven -w /usr/src/mymaven maven:3.8.1-openjdk-17 mvn clean install -DskipTests