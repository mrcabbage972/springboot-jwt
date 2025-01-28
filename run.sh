#!/bin/bash

chmod +x run.sh
chmod +x run_all.sh
./run_all.sh
chmod +x docker_build_run.sh
docker build -t springboot-jwt .
docker run -it --rm springboot-jwt mvn test