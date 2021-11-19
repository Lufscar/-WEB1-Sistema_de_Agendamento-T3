# Desenvolvimento de Software para Web
 * [Sobre](#About)
 * [Configurações](#Configurações)
 * [Funcionalidades](#Funcionalidades)
 * [Requisitos](#Requisitos)
 
### About
 
Projeto 2 de Web, disciplina ministrada pelo professor Delano.

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
 
 4- Acesse http://localhost:8080
 
 ### Funcionalidades
 
 Para testar as funcionalidades do sistema:
 
 1- Na tela inicial já é exibida uma tabela com todos profissionais cadastrados, logo abaixo, há um campo que possibilita filtrar os funcionários pela área de atuação. No canto superior direito há os botões de escolha de idioma português-brasileiro e inglês.
 
 2- Também na tela inicial há um botão "Login" que leva para a tela de autentificação de usuário. Para acessar como administrador, utilize login e senha "admin", na tela de administrador é exibido uma tabela de clientes e uma de profissionais, e nessa tela concede acesso aos seus respectivos CRUDs.

 3- Após testar os CRUDs, volte para a tela de login e faça login como cliente (utilize login: "cli@cli.com", senha: "1234") ou como profissional (utilize login: "pro@pro.com", senha: "1234").
 
 4- Na tela de cliente é possivel agendar uma consulta e visualizar uma lista das consultas marcadas. Na tela de profissional é possivel apenas visualizar uma lista das consultas marcadas.
 
 ### Requisitos
 - Cadastro de Clientes:  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

 - Cadastro de Profissionais:  ( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

Faltou apenas a submissão do currículo

-  Cadastro de Consultas: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

 - R1: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- R2: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- R3: ( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

Faltou apenas o filtro por especialidade

- R4: ( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

Faltou apenas personilizar o envio de emails para o profissional e cliente específicos - estão sendo enviados para um email criado para testes da disciplina: trab.web.ufscar@gmail.com

- R5: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- R6: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- R7: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- R8: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- R9: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Página de erros amigável: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido

- Observação: Todos os requisitos foram igualmente divididos pois a maior parte do trabalho foi feita enquanto estávamos reunidos, outras poucas partes feitas individualmente foram divididas de maneira equilibrada.