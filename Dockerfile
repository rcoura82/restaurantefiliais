# Etapa 1: Build da aplicação
FROM maven:3.9.4-eclipse-temurin-21-focal AS build
WORKDIR /app

# Copiar os arquivos do projeto para o contêiner
COPY pom.xml .
COPY src ./src

# Baixar dependências e compilar o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final para execução
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiar o artefato gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Definir o comando de entrada para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]