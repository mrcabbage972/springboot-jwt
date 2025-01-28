#!/bin/bash

docker build -t springboot-jwt .

docker run -it --rm springboot-jwt mvn test