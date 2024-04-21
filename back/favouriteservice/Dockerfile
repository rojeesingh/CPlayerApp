FROM openjdk:17
ENV MONGO_DATABASENAME=favdb
ENV MONGO_HOST=localhost
ENV MONGO_PORT=27017
ADD target/favouriteservice-2.7.0.jar favouriteservice.jar
ENTRYPOINT ["java","-jar","favouriteservice.jar"]
