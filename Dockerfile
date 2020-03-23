FROM openjdk:8
ADD target/tenpo-api.jar tenpo-api.jar
EXPOSE 6080
ENTRYPOINT ["java","-jar","tenpo-api.jar"]
