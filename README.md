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
- git clone https://github.com/Pedrolucasrd/TRABALHO_LP2_2023.git
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
java -jar target/TRABALHO_LP2_2023-1.0.0.jar
```
### O aplicativo estará disponível 

- http://localhost:5050

### Acesso ao Swagger

### O Swagger é uma ferramenta útil para documentar e testar APIs. Você pode acessar a documentação Swagger em:

- http://localhost:5050/swagger-ui.html

### Endpoints da API

## produto-veiculo-controller

- /produto-veiculo/mudar-leilao/{idProduto}/{idLeilao}
- /produto-veiculo/atualizar/{id}
- /produto-veiculo/criar/{leilaoId}
- /produto-veiculo/criar/utilitario/{leilaoId}
- /produto-veiculo/criar/motocicleta/{leilaoId}
- /produto-veiculo/criar/carro/{leilaoId}
- /produto-veiculo/criar/caminhao/{leilaoId}
- /produto-veiculo/{idProduto}
- /produto-veiculo/listar-todos
- /produto-veiculo/deletar/{id}

## produto-informatica-controller

- /produto-informatica/mudar-leilao/{idProduto}/{idLeilao}
- /produto-informatica/atualizar/{id}
- /produto-informatica/criar/{leilaoId}
- /produto-informatica/criar/switch/{leilaoId}
- /produto-informatica/criar/roteador/{leilaoId}
- /produto-informatica/criar/notebook/{leilaoId}
- /produto-informatica/criar/monitor/{leilaoId}
- /produto-informatica/criar/hub/{leilaoId}
- /produto-informatica/criar/{leilaoId}
- /produto-informatica/listar-todos
- /produto-informatica/deletar/{id}

## leilao-controller
- /leilao/criar
- /leilao/consultar/{id}
- /leilao/deletar/{id}

## cliente-controller
- /cliente/atualizar-cliente/{cpf}
- /cliente
- /cliente/procurar-por-cpf/{cpf}
- /cliente/procurar-lances-por-cpf/{cpf}
- /cliente/listar-todos
- /cliente/deletar/{cpf}

## lance-controller
- /lance/gerar-lance-produto-informatica/{produtoId}/{clienteCpf}/{valor}/{categoriaProduto}


## instituicao-financeira-controller
- /instituicao-financeira/atualizar/{id}
- /instituicao-financeira/vincular-leilao-instituicao/{idLeilao}/{idInstituicao}
- /instituicao-financeira/criar
- /instituicao-financeira/consultar/{id}
- /instituicao-financeira/consultar/leilao/{id}
- /instituicao-financeira/deletar/{id}

