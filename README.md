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
A API segue, basicamente, a especificação rest para nomear as suas rotas, realizando as 
funcionalidades básicas.

 [Documentação das rotas da API](https://documenter.getpostman.com/view/3419565/mussum-api/RW1Yr26P).



## How to Start
```bash
$ git clone https://github.com/angelogluz/Mussum-API.git
$ cd Mussum-API
# <b>Inicialize o MySQL</b>
# Com o MySQL inicializado, faça o build do projeto
$ ./mvnw package
$ npm install
# watches your files and uses livereload by default run `npm start` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.
$ npm start
# prod build, will output the production application in `dist`
# the produced code can be deployed (rsynced) to a remote server
$ npm run build

Inicialize o MySQL em sua máquina
```
## Contribuição
Veja [CONTRIBUTING.md](CONTRIBUTING.md).

## Heroku
A API está disponível em <link> https://mussumapi.herokuapp.com/ </link> seguido da rota
especificada acima.
