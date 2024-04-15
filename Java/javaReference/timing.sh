#!/bin/bash


# Compile the Java file
javac YourJavaFile.java

# Number of iterations
ITERATIONS=1000

# Loop to run the Java program and measure execution time
for ((i = 1; i <= $ITERATIONS; i++)); do
    echo "Iteration $i"
    # Measure the execution time of the Java program using the time command
    time java YourJavaFile
done

