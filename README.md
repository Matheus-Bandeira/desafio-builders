# Desafio Builders
Projeto para Etapa de Validação - Vaga Senior Java Developer - Cód. 484

Link da aplicação:
https://desafio-builders.herokuapp.com/swagger-ui.html

## Configuração

Aplicação desenvolvida com as seguintes versões:

- Apache Maven: 3.8.2
- JDK: 11
- Spring Boot: 2.4.4
- Banco de dados: MySql

## 1. Acesso à aplicação

- Git clone para baixar a aplicação;

Com o CMD aberto na raiz no projeto, execute uma das seguintes opções: 
 
- mvn spring-boot:run
- mvn install -DskipTest && cd target && java -jar builders-api-0.0.1-SNAPSHOT.jar

Acesso:
- A aplicação será executada na porta 8080.
- Endereço do Swagger: http://localhost:8080/swagger-ui.html

## 2.	Requisições via Postman

- Importar o arquivos Builders.postman_collection.json no Postman. Este arquivo está no diretório do projeto do projeto pasta Collections.

## 3. Como	executar	os	testes

- Com o CMD aberto na raiz no projeto, execute: mvn test

## 4. Executando a aplicação pelo docker

- Ir no arquivo application.properties do projeto e alterar o perfil para "DEV".
- No arquivo application-dev.properties está configurado com o docker.
- Abrir o cmd na raiz do projeto, onde está o arquivo docker-compose.yml. Neste arquivo tem as configurações necessárias para baixar e executar o backend e configurar o MySql.
- Executar o comando -> docker compose up
- Aplicação será iniciada na porta 8080 e o mysql na porta 3306 por default
- Acessar o link: http://localhost:8080/swagger-ui.html


## Processo de criação

- Modelagem da estrutura do projeto separando em pacotes e responsabilidade por camadas. modelo, entitidade, serviço e endpoints
- Documentação dos endpoints utilizando Swagger
- Criação e validação do banco de dados usando Jpa/Hibernate
- Testes de integração com a camada de acesso ao banco de dados e unitarios com pequenas partes do codigo
- Geração da collection no postman ao finalizar os testes de cada endpoint
- Deploy da aplicação utilizando Heroku
- Criação da imagem do backend para publicar no docker
- Criação do arquivo docker-compose.yml para relacionar o backend com mysql

## Observações

- No arquivo de configuração application.properties é necessário colocar om perfil da aplicação.
- De início, foi configurado 3 perfis : test, dev e prod.
- No arquivo application-dev.properties tem 2 configurações : banco local e do banco no docker.

