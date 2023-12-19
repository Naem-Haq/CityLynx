FROM openjdk:21
WORKDIR /opt

# Copy .class files from the target directory into the image
COPY CityLynx/target/classes/*.class /opt/

# Create a JAR file from the .class files
RUN jar cvf app.jar *.class

# Remove the individual .class files (optional)
RUN rm -rf *.class

# Set the command to run the Java Application
CMD ["java","-jar","app.jar"]
