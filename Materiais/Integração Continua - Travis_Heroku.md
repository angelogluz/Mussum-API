# Integração Contínua - Travis-CI

Primeiro passo é criar um arquivo <code>.travis.yml</code> na raiz do projeto.

Também é necessário criar uma conta em <link>https://travis-ci.org/</link>. Ao criar a conta, pode-se logar com o GitHub e já autorizar o travis no repositório.

## Heroku

Seguir <b>Getting Started on Heroku with Java</b> conforme tutorial do site.

<b> Resumo </b>

Após instalar o Heroku CLI, as principais tarefas são:

### Logar no Heroku

```bash 
$ heroku login
Enter your Heroku credentials.
Email: java@example.com
Password:
```

### Cria aplicação no Heroku e o remoto no git

```bash
Heroku create <nome da aplicação>
```

### Conectando o Heroku com o Github

Em <code>Settings/Deploy/Deployment method</code> troque de Heroku para Github.

### Adicionando conexão com banco de dados MySQL

<b>ATENÇÃO!</b> Será necessário inserir um cartão de crédito válido para adicionar o addon.

Adicione o addon para trabalhar com o ClearDB MySQL em <link>https://elements.heroku.com/</link>, ou pelo terminal com o 
comando a seguir:

```bash
Heroku addons:create cleardb
```
ou
```bash
Heroku addons:create jawsdb
```

Realizada a instalação, em <code>Resources</code> já pode ser acessado o banco de dados ClearDB.

Nas configurações do Heroku pegue as informações referente ao banco de dados a utilizar
```bash
heroku config --app <nome do seu app no heroku>
```

## Criar profiles de produção e dev

Crie um arquivo chamada <code>Procfile</code> na raiz do projeto.

O arquivo Procfile serve para especificar alguns parâmetros para o Heroku, e nele podemos especificar o perfil do Spring 
que deve executar, que no caso será o <code>prod</code>. O conteúdo padrão do arquivo pode ser encontrado em 
<code> Resources/Dynos</code>, e deve ter um código similar a:

```
web: java -Dserver.port=$PORT $JAVA_OPTS -jar target/APX-0.0.1-SNAPSHOT.jar
```
onde é identificado o tipo de aplicação, a porta, o empacotamento da aplicação, entre outras coisas.

Para especificar que vamos rodar o perfil de produção do spring, precisamos adicionar além do conteúdo padrão, o parâmetro
<code>-Dspring.profiles.active=prod</code>, ficando com o arquivo com conteúdo similar a: 

```
web: java -Dserver.port=$PORT -Dspring.profiles.active=prod $JAVA_OPTS -jar target/APX-0.0.1-SNAPSHOT.jar
```

### Criando arquivo de configuração de produção

Neste momento, no nosso <code>application.properties</code> temos as configurações de acesso do nosso banco de dados <b>local</b>.

Podemos criar agora um arquivo chamado <code>application-prod.properties</code>. Este é uma espécie de especialização
do <code>application.properties</code>, e as propriedades especificadas nele substituirão as do 
<code>application.properties</code> quando alterarem uma mesma propriedade.

Exemplo de arquivo de produção:

```
spring.datasource.url= jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_a84f472d5366356?reconnect=true
spring.datasource.username=b36c618413bf8c
spring.datasource.password=d14d96e0
```

Agora, quando rodar sua aplicação local, irá utilizar seu banco de dados local, quando rodar no heroku, 
irá utilizar o ClearDB.

## Links importantes

https://travis-ci.org/

https://www.heroku.com/

https://docs.travis-ci.com/user/deployment/heroku/




