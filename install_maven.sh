#!/bin/bash
# Download Maven
wget https://dlcdn.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz

# Extract Maven
tar -xzf apache-maven-3.9.4-bin.tar.gz

# Set Maven environment variables
export M2_HOME=$PWD/apache-maven-3.9.4
export PATH=$PATH:$M2_HOME/bin

# Make mvn executable
chmod +x $M2_HOME/bin/mvn

# Run maven install
mvn install