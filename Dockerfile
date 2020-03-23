FROM openjdk:8
ADD target/tenpo-test-api.jar tenpo-test-api.jar
EXPOSE 6080 5432
ENTRYPOINT ["java","-jar","tenpo-test-api.jar"]
