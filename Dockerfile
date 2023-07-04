FROM openjdk:17-jdk-alpine
EXPOSE 8080
ADD target/*.jar webservice.jar
ENTRYPOINT ["java","-jar","/webservice.jar"]