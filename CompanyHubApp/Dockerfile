FROM eclipse-temurin:21-jdk

RUN apt update && apt install -y \
    maven \
    git \
    && rm -rf /var/lib/apt/lists/* \

WORKDIR /workspace

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/CompanyHubApp-0.0.1-SNAPSHOT.jar"]