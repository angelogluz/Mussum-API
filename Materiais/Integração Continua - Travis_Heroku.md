# Integração Contínua - Travis-CI

Primeiro passo é criar um arquivo <code>.travis.yml</code> na raiz do projeto.

Também é necessário criar uma conta em <link>https://travis-ci.org/</link>. Ao criar a conta, pode-se logar com o GitHub e já autorizar o travis no repositório.

## Heroku

Seguir <b>Getting Started on Heroku with Java</b> conforme tutorial do site, que em resumo é:

Após <b>instalar o Heroku CLI</b>, as principais tarefas são:

### Logar no Heroku

```bash 
$ heroku login
Enter your Heroku credentials.
Email: java@example.com
Password:
```

### Cria aplicação no Heroku e o remoto no git
Navegar até o <b>diretório do projeto</b>, que já deverá estar versionado e criar a aplicação no heroku.

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

Nas configurações do Heroku pode ser vista a variável que contém as informações do banco.

```bash
heroku config --app <nome do seu app no heroku>
```

## [Opcional] Criar profiles de produção e dev

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

### [Opcional] Criando arquivo de configuração de produção

Neste momento, no nosso <code>application.properties</code> temos as configurações de acesso do nosso banco de dados <b>local</b>.

Podemos criar agora um arquivo chamado <code>application-prod.properties</code>. Este é uma espécie de especialização
do <code>application.properties</code>, e as propriedades especificadas nele substituirão as do 
<code>application.properties</code> quando alterarem uma mesma propriedade.

Exemplo de arquivo de produção:

<b> Por default o Heroku já aplica o DB criado sem necessidade desta configuração explícitando o banco. </b>

```
spring.datasource.url= jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_a84f472d5366356?reconnect=true
spring.datasource.username=b36c618413bf8c
spring.datasource.password=d14d96e0
```

Agora, quando rodar sua aplicação local, irá utilizar seu banco de dados local, quando rodar no heroku, 
irá utilizar o ClearDB.

## Fazendo deploy

Após tudo configurado podemos fazer o deploy basicamente de duas formas:

### Repositório do Heroku
Quando criada a aplicação no heroku pelo <code>Heroku create</code>, um remote foi adicionado ao nosso git,
apontando para um repositório no heroku. Se enviarmos para lá nosso push, o deploy será executado.

```bash
git push heroku master
```

### Repositório do github
Se o <b> Deployment method </b> estiver sido alterado para o Github, conforme mostrado anteriormente, pode-se também,
no mesmo lugar, selecionar o <b> deploy automático</b> e também que ele só seja realizado apenas de o projeto for
<b>aprovado pelo CI (travis)</b>.

Sendo assim, quando der o push para o github, automaticamente o deploy será realizado.

```bash
git push origin master
```

### Garantindo execução do app
Para garantir a execução da sua aplicação, execute o seguinte comando:

```bash
heroku ps:scale web=1
```

## Links importantes

https://travis-ci.org/

https://www.heroku.com/

https://docs.travis-ci.com/user/deployment/heroku/




