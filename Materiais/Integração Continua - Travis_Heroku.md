# Integração Contínua (CI)


## Características

## Criar profiles de produção e dev

Adicionar dependência
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-configuration-processor</artifactId>
	<optional>true</optional>
</dependency>
```

Criar pacote <code> config.property </code> e criar uma classe para definição das propriedades.
```java


```

## Travis-CI

.travis.yml

Ao criar a conta, pode-se logar com o GitHub e já autorizar o travis no repositório.


## Heroku

Seguir <b>Getting Started on Heroku with Java</b> conforme tutorial do site.


Instalar Heroku CLI.

```bash
Heroku login
``

```bash 
$ heroku login
Enter your Heroku credentials.
Email: java@example.com
Password:
```

\# Cria o remoto (git) para enviar para o Heroku

```bash
Heroku create
```

<code>Settings/Deploy/Deployment method</code> e troque de Heroku para Github.


## Links importantes

https://travis-ci.org/

https://docs.travis-ci.com/user/deployment/heroku/


