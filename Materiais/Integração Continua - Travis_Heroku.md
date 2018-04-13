# Integração Contínua (CI)


## Características





## Travis-CI

.travis.yml

Ao criar a conta, pode-se logar com o GitHub e já autorizar o travis no repositório.


## Heroku

Seguir <b>Getting Started on Heroku with Java</b> conforme tutorial do site.


Instalar Heroku CLI.


```bash 
$ heroku login
Enter your Heroku credentials.
Email: java@example.com
Password:
```

\# Cria aplicação no Heroku e o remoto no git

```bash
Heroku create <nome da aplicação>
```

<code>Settings/Deploy/Deployment method</code> e troque de Heroku para Github.

Adicione o addon para trabalhar com o ClearDB MySQL em <link>https://elements.heroku.com/</link>, ou pelo terminal com o 
comando a seguir:
```bash
Heroku addons:create cleardb
```
ou
```bash
Heroku addons:create jawsdb
```

<b>ATENÇÃO!</b> Será necessário inserir um cartão de crédito válido para adicionar o addon.

Realizada a instalação, em <code>Resources</code> já pode ser acessado o banco de dados ClearDB.

```bash
heroku config --app <nome do seu app no heroku>
```

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

Crie um arquivo chamada <code>Procfile</code> na raiz do projeto.

O arquivo Procfile serve para especificar alguns parâmetros para o Heroku, e nele podemos especificar o perfil do Spring 
que deve executar, que no caso é o <code>prod</code>, que poderia ficar assim:
```
web: java -Dserver.port=$PORT -Dspring.profiles.active=prod $JAVA_OPTS -jar target/APX-0.0.1-SNAPSHOT.jar
```



## Links importantes

https://travis-ci.org/

https://docs.travis-ci.com/user/deployment/heroku/


