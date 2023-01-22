FROM openjdk:latest
COPY  ./target/messageservice-0.0.1-SNAPSHOT.jar message_service.jar
CMD ["java","-jar","/message_service.jar"]