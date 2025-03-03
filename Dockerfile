# Etapa de build
FROM openjdk:21-jdk-slim AS build

WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Dá permissão de execução para o Maven Wrapper
RUN chmod +x mvnw

# Executa o Maven para construir o JAR
RUN ./mvnw clean package -DskipTests

# Etapa final: apenas o JAR será incluído na imagem
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=build /app/target/calculadora-boi-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta usada pelo Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
