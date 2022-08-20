FROM maven:3.8.3-amazoncorretto-17
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests
CMD ["java","-jar","target/challenge-b2w-0.0.1-SNAPSHOT.jar"]
