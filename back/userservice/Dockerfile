FROM openjdk:17
ENV  MYSQL_DATABASENAME=cplayerdb
ENV  MYSQL_URL=jdbc:mysql://localhost:3306/userservice?createDatabaseIfNotExist=true
ENV  MYSQL_USERNAME=root
ENV  MYSQL_PASSWORD=Rojee@123
ADD target/userservice-2.7.0.jar userservice.jar
ENTRYPOINT ["java","-jar","userservice.jar"]
