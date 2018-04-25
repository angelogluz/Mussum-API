[![Build Status](https://travis-ci.org/angelogluz/Mussum-API.svg?branch=master)](https://travis-ci.org/angelogluz/Mussum-API)

# Mussum API
Projetos Spring Boot API utiliza/exemplifica os principais módulos do <b>Spring-boot 2.0.0</b>.

## Módulos
* DevTools
* Web
* JPA
* MySQL
* Flyway

## Rotas
A API segue, basicamente, a especificação rest em para nomear as suas rotas, realizando as 
funcionalidades básicas:

### Aula
* /aulas/{id},methods=[GET]
* /aulas,methods=[GET]
* /aulas?limit={limit}=[GET]
* /aulas,methods=[POST]
* /aulas/{id},methods=[DELETE]


### Conteúdo
* /conteudos/{id},methods=[GET]
* /conteudos,methods=[GET]
* /conteudos,methods=[POST]
* /conteudos/{id},methods=[DELETE]
### Curso
* /cursos/{id},methods=[GET]
* /cursos,methods=[GET]
* /cursos,methods=[POST]
* /cursos/{id},methods=[DELETE]
### Unidade
* /unidades/{id},methods=[GET]
* /unidades,methods=[GET]
* /unidades,methods=[POST]
* /unidades/{id},methods=[DELETE]

## Contribuição
Veja [CONTRIBUTING.md](CONTRIBUTING.md).

## Heroku
A API está disponível em <link> https://mussumapi.herokuapp.com/ </link> seguido da rota
especificada acima.
