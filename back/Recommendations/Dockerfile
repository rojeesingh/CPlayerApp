FROM openjdk:17
ENV MONGO_DATABASENAME=favdb
ENV MONGO_HOST=localhost
ENV MONGO_PORT=27017
ADD target/Recommendations-0.0.1-SNAPSHOT.jar recommendations.jar
ENTRYPOINT ["java","-jar","recommendations.jar"]
