FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean install -DskipTests

EXPOSE 9090

ENTRYPOINT ["java","-jar","target/personal-finance-management-system-0.0.1-SNAPSHOT.jar"]
