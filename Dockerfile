FROM openjdk:21
WORKDIR /opt

# Copy .class files from the target directory into the image
COPY target/*.jar /opt/

# Set the command to run the Java Application
CMD ["java","-jar","app.jar"]
