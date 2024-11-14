FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean package

CMD ["java", "-jar", "target/library_api-0.0.1-SNAPSHOT.jar"]