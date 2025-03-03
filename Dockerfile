# Usa uma imagem do OpenJDK 21
FROM openjdk:21-jdk-slim AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos do projeto para dentro do contêiner
COPY . .

# Executa o Maven para construir o JAR
RUN ./mvnw clean package -DskipTests

# Segunda etapa: imagem final
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=build /app/target/calculadora-boi-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
