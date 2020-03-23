# springboot-jpa-rest
This is a simple math operation done in springboot-jpa-rest which includes followed functionalities.
1. SignUp
2. Login
3. Sum of two numbers with proper login.
4. Store the above operations.
#Docker info
Step 1:
Pull the image from the dockerhub ->  docker pull sanjanamurugesan/tenpo-api

Step 2:
If postgres not running in your container container, execute the below command:
2. docker run --name postgres-standalone -d -p 5432:5432 -e POSTGRES_ROOT_PASSWORD=Elohim@123 -e POSTGRES_DATABASE=public -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=Elohim@123 -d postgres:latest

Step 3:To run Rest Api.
3. docker run -p 6080:6080 --name tenpo-api --link postgres-standalone:postgres -d tenpo-api

Step 4:
Please refer postman_collection directory in master branch and import and test it:
Ex: http://localhost:6080/addUser
Note: You can change your postgres desired password & and also port numbers which is also applicable in application.properties.
