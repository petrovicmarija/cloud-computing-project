#FROM openjdk:17-alpine
#EXPOSE 8080
#ADD target/uns-app-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]

FROM maven:3.8.5-openjdk-17-slim AS unsAppBuild
WORKDIR /root/src/backend
COPY . .
RUN mvn package -DskipTests

FROM openjdk:17 AS unsAppRuntime
WORKDIR /app
COPY --from=unsAppBuild /root/src/backend/target/uns-exe.jar ./
EXPOSE 8080
CMD java -jar uns-exe.jar