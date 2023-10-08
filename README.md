# TRABALHO_LP2_2023

## Trabalho Final de Programação Orientada a Objetos

# Projeto Spring Boot com Maven e Swagger

Este é um exemplo de projeto Spring Boot configurado com Maven e Swagger para facilitar o desenvolvimento, teste e documentação da API.

## Requisitos Prévios

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) - Versão 8 ou superior
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://github.com/Pedrolucasrd/TRABALHO_LP2_2023)

## Configuração do Ambiente

Certifique-se de que você tenha instalado o JDK e o Maven corretamente. Você pode verificar as versões com os seguintes comandos:

```bash
java -version
mvn -version

```
## Clone o Repositório
```
- git clone https://github.com/seu-usuario/seu-projeto.git
- cd seu-projeto
```
## Build e Execução do Projeto
### Para construir e executar o projeto, siga estas etapas:

### Navegue até o diretório raiz do projeto:
```
- cd seu-projeto
```
### Compile o projeto usando o Maven:
```
- mvn clean install
```
### Execute o aplicativo Spring Boot:
```
java -jar target/seu-projeto-1.0.0.jar
```
### O aplicativo estará disponível 

- http://localhost:8080

### Acesso ao Swagger

### O Swagger é uma ferramenta útil para documentar e testar APIs. Você pode acessar a documentação Swagger em:

- http://localhost:8080/swagger-ui.html

### Endpoints da API

- /api/endpoint1: Descrição do endpoint 1.
- /api/endpoint2: Descrição do endpoint 2.

### Testes

- Você pode executar testes unitários com o seguinte comando:
  
```
mvn test

```
