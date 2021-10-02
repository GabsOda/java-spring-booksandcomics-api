# Sistema de gerenciamento de livros, quadrinhos e mangas em API REST com Spring Boot

Foi desenvolvido um pequeno sistema para o gerenciamento de livros, quadrinhos e mangas através de uma API REST, criada com o Spring Boot.

Este projeto foi realizado seguindo como base o projeto "Desenvolvendo um sistema de gerênciamento de pessoas em API REST com Spring Boot" realizado pelo Rodrigo Peleias na plataforma online Digital Innovation One. 

Foram realizados no desenvolvimento desse projeto:

* Setup inicial de projeto com o Spring Boot Initialzr
* Criação de modelo de dados para mapeamento de entidades em bacos de dados
* Desenvolvimento de operações de genênciamento (cadastro, leitura, atualização e remoção de um sistema)
* Relacionamento de cada uma das operações acima com o padrão arquitetural REST
* Deploy em nuvem através do Heroku

## Foram utilizados como depêndecias desse projeto

* spring-boot-starter-actuator
* spring-boot-starter-data-jpa
* spring-boot-starter-validation
* spring-boot-starter-web
* spring-boot-devtools
* h2, como banco de dados em memória
* lombok
* mapstruct, na versão 1.4.2.Final
* mapstruct-processor, na versão 1.4.2.Final

## Pré-Requisitos 
São necessários os seguintes pré-requisitos para a execução desse simples projeto:

* Java 11 ou versões superiores.
* Maven 3.6.3 ou versões superiores.

Para executar o projeto no terminal, digite o seguinte comando no diretório do projeto:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/book
``` 

Lembrando que este projeto é uma API REST, então não haverão telas para realização das funções, onde para tal pode ser realizado, por exemplo, através de uma plataforma como o Postman. 