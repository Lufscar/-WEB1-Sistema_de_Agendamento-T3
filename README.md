# Desenvolvimento de Software para Web
 * [Sobre](#About)
 * [Configurações](#Configurações)
 * [Funcionalidades](#Funcionalidades)
 * [Requisitos](#Requisitos)
 
### About
 
Projeto 3 de Web, disciplina ministrada pelo professor Delano.

Implementação por:
  - Anderson Henrique Giacomini, 769720
  - Jean Araujo, 620394
  - Luciana Oliveira de Souza Gomes, 743569
  
### Configurações 

1- Clone a branch Master deste repositório, baixe e configure o MySQL e o Tomcat no seu computador, conforme demonstrado nas aulas. 

2- Para configurar o banco de dados, execute o seguinte comando no MySQL:

```sql 

drop database SistemaAgendamento;

create database SistemaAgendamento;
 
 ```
 
 3- Compile e execute o projeto usando o comando a seguir
 
 ```
 mvn spring-boot:run
 ```
 
 ### Funcionalidades REST API
 
 1- Recomendamos utilizar o Postman (https://www.postman.com/) para testar as funcionalidades.
 Confira os testes realizados com sucesso presentes na pasta de imagens "TESTES" presente neste repositório.
 
 ### Funcionalidades diretamente do site
 
 Para testar as funcionalidades do sistema diretamente no site, acesse em seu navegador: http://localhost:8080/
 
 1- Na tela inicial já é exibida uma tabela com todos profissionais cadastrados, logo abaixo, há um campo que possibilita filtrar os funcionários pela área de atuação. No canto superior direito há os botões de escolha de idioma português-brasileiro e inglês.
 
 2- Também na tela inicial há um botão "Login" que leva para a tela de autentificação de usuário. Para acessar como administrador, utilize login e senha "admin", na tela de administrador é exibido uma tabela de clientes e uma de profissionais, e nessa tela concede acesso aos seus respectivos CRUDs.

 3- Após testar os CRUDs, volte para a tela de login e faça login como cliente (utilize login: "cli@cli.com", senha: "1234") ou como profissional (utilize login: "pro@pro.com", senha: "1234").
 
 4- Na tela de cliente é possivel agendar uma consulta e visualizar uma lista das consultas marcadas. Na tela de profissional é possivel apenas visualizar uma lista das consultas marcadas.
 
 ### Requisitos

- Cria um novo cliente [Create - CRUD]
POST http://localhost:8080/clientes
Body: raw/JSON (application/json)

( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Retorna a lista de clientes [Read - CRUD]
GET http://localhost:8080/clientes

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Retorna o cliente de id = {id} [Read - CRUD]
GET http://localhost:8080/clientes/{id}

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Atualiza o cliente de id = {id} [Update - CRUD]
PUT http://localhost:8080/clientes/{id}
Body: raw/JSON (application/json)

( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Remove o cliente de id = {id} [Delete - CRUD]
DELETE http://localhost:8080/clientes/{id}
REST API -- CRUD de profissionais

( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Cria um novo profissional [Create - CRUD]
POST http://localhost:8080/profissionais
Body: raw/JSON (application/json)

( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Retorna a lista de profissionais [Read - CRUD]
GET http://localhost:8080/profissionais

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Retorna o profissional de id = {id} [Read - CRUD]
GET http://localhost:8080/profissionais/{id}

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Retorna a lista de todos os profissionais de especialidade cujo nome = {nome}
GET http://localhost:8080/profissionais/especialidades/{nome}

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Atualiza o profissional de id = {id} [Update - CRUD]
PUT http://localhost:8080/profissionais/{id}
Body: raw/JSON (application/json)

( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Remove o profissional de id = {id} [Delete - CRUD]
DELETE http://localhost:8080/profissionais/{id}

( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- REST API -- Retorna a lista de consultas [Read - CRUD]
GET http://localhost:8080/consultas

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- REST API -- Retorna a consulta de id = {id} [Read - CRUD]
GET http://localhost:8080/consultas/{id}

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- REST API -- Retorna a lista das consultas do cliente de id = {id} [Read - CRUD]
GET http://localhost:8080/consultas/clientes/{id}

( ) Implementado ( ) Parcialmente implementado (X) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- REST API -- Retorna a lista das consultas do profissional de id = {id} [Read - CRUD]
GET http://localhost:8080/consultas/profissionais/{id}

( ) Implementado ( ) Parcialmente implementado (X) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido
 

- Observação: Todos os requisitos foram igualmente divididos pois a maior parte do trabalho foi feita enquanto estávamos reunidos, outras poucas partes feitas individualmente foram divididas de maneira equilibrada.
