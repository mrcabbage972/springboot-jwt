#!/bin/bash\n\ndocker build -t springboot-jwt .\ndocker run -it --rm springboot-jwt mvn test