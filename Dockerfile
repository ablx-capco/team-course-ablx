FROM openjdk:12-jdk-alpine
COPY alexcourse-0.1.jar alexcourse-0.1.jar
CMD ["java","-jar","alexcourse-0.1.jar"]