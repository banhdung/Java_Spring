FROM openjdk:21

ARG FILE_JAR=target/*.jar

ADD ${FILE_JAR} api-service.jar

ENTRYPOINT ["java", "-jar", "api-service.jar"]

EXPOSE 80

#docker build -t api-image-sample .
#docker run -it -p 80:80 --name=api-container-3 api-image-sample
##docker-compose up -d