# Projeto xy-inc

Para o desenvolvimento do projeto foi utilizado a linguagem Java com o framework Spring pela facilidade em criar e manter o projeto.

Banco de dados utilizado é o H2 Database, pela simplicidade do uso e sem a necessidade de configuração de ambiente de banco, banco é adequado para o projeto que não exige recursos avançados.

# Tecnologias Utilizadas

Spring Boot

Spring Data

Rest

Hiberte

Java 8

Junit 5

H2 Database

# Como utilizar o projeto

Para utilizar o projeto é necessário ter Java 8 e Maven instalado e configurado (variáveis de ambiente).

versão Maven utilizada 3.6.1

# Como executar o projeto

1 - Clone o projeto https://github.com/LuisEduardoM/xy-inc.git

2 - Entre na pasta xy-inc através de um terminal e execute os comandos abaixo:

$ mvn clean package

$ java -jar target\xy-inc.jar

3 - A aplicação irá rodar na porta 8100 no servidor local.

# Como utilizar os serviços da API

Listar todos

GET http://localhost:8100/pontoInteresse/listarTodos

Buscar por proximidade

GET http://localhost:8100/pontoInteresse/buscarPorProximidade?coordenadaX=20&coordenadaY=10&distanciaMaxima=10

Salvar

POST localhost:8100/pontoInteresse/salvar { "nome": "Churrascaria", "coordenadaX": 28, "coordenadaY": 2 }

# Testes

O projeto possui testes unitários, testes de repositório, serviço e controlador. Para rodar os testes basta executar o seguinte comando:

$ mvn test
