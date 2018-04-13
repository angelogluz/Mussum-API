# Flyway
Ferramenta para migração de banco da dados que nos ajuda a ter um fácil controle de versão do banco de dados e nos 
auxilia a atualizar banco de dados em produção.

## Características
* Fácil configuração em tecnologias diversos (Java, Node, ...)
* Integração com Spring
* Resolve problemas específicos sem impacto no restante do banco
* Entrega contínua
* Cria uma tabela para controlar o schema de migrações <code> flyway_schema_history </code>
* **Não é aconselhável** editar uma migration criada - faz com que o checksun seja invalidado
* O recomendado é começar as migrations em um banco de dados vazio

## Adicionando no Spring boot
O Spring boot já possui integração com o Flyway, que já pode ser especificado no momento da criação do projeto como um 
dos módulos do Spring, e em caso de um projeto já criado, basta adicionar a dependência do Flyway no arquivo <b>pom.xml</b>.

```xml
<dependency>
    <groupId>org.flywaydb</groupId>
	<artifactId>flyway-core</artifactId>
</dependency>
```

Adicionada a dependência, bastar criar em nosso projeto um diretório <code> db/migration </code> dentro do diretório <code> resources </code>, que é 
onde nossas migrações serão procuradas. Este é o caminho padrão, mas pode ser alterado no <code>application.properties</code>
alterando a propriedade <code>spring.flyway.locations</code>

## Realizando migração 
Dentro do diretório migration, serão adicionados scripts sql seguindo um padrão de nomenclatura, que deverá ser: <code>
V\<VERSION>__\<NAME>.sql</code>

Exemplo de nome para arquivo de migração: 
<code>V001__Criar_Tabela_de_Unidades.sql</code>

Onde deverá iniciar com o <b>V</b>, seguido de um número que identifique a versão da migração. Após o identificador o 
nome do arquivo deverá possuir dois <b>underlines</b> seguido da descrição da migração separada por underlines e por 
fim adicionada a extensão <code>.sql</code>.

Dentro do arquivo deverá ser adicionado o <code> sql </code> que se deseja executar, como por exemplo:

```sql
CREATE TABLE unidade (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  ativo boolean,
  nome varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

O Flyway executará nossa migration e atualizará nosso banco de dados, criando um arquivo  <code>flyway_schema_history</code>
para controlar nossas migrações. 
O arquivo <code>flyway_schema_history</code> possui as colunas apresentadas a seguir, que possui boa parte dos seus valores
associados ao nome que foi utilizado na criação do arquivo de migração.

| Installed_rank | version |        description       | type |            script                |  checksum  | installed_by |      installed_on     | execution_time | sucess |
|:--------------:|:-------:|:------------------------:|:----:|:--------------------------------:|:----------:|:------------:|:---------------------:|:--------------:|:------:|
|        1       |    1    | Criar Tabela de Unidades |  SQL | V001__Criar_Tabela de_Unidades   | 1996767037 |     root     | 2018-02-04 22:23:00.0 |       320      |  true  |

### Se quiser popular a tabela de unidade, o que fazer?

Em um primeiro momento, a ideia poderia ser editar a primeira migração e adicionar os <code> insert </code>, mas se fizermos
isso, ao tentar executar a migração teremos um erro de checksun, pois será identificado uma alteração em uma migração já realizada.

Para executar a migração em um caso assim, o banco de dados precisa ser apagado, ou, mais precisamente a tabela <code>flyway_schema_history</code>

O mais correto seria criar uma nova migraão para popular a tabela, que poderia ser uma <code>V002__Popular_Tabela_de_Unidades.sql</code>

Observe que, obviamente, precisamos incrementar o identificador da versão e a descrição da migração.

Exemplo de conteúdo da migração:
```sql
INSERT INTO unidade
    (ativo, nome)
    VALUES
    (true, "Algoritmos e Programação III");
INSERT INTO unidade
    (ativo, nome)
    VALUES
    (true, "Engenharia de Software II");
INSERT INTO unidade
    (ativo, nome)
    VALUES
    (false, "Algoritmos e Programação II");
```

E com isso teríamos nossa tabela do Flyway mais ou menos assim: 

| Installed_rank | version |        description       | type |            script                |  checksum  | installed_by |      installed_on     | execution_time | sucess |
|:--------------:|:-------:|:------------------------:|:----:|:--------------------------------:|:----------:|:------------:|:---------------------:|:--------------:|:------:|
|        1       |    1    | Criar Tabela de Unidades |  SQL | V001__Criar_Tabela de_Unidades   | 1996767037 |     root     | 2018-02-04 22:23:00.0 |       320      |  true  |
|        2       |    2    |Popular Tabela de Unidades|  SQL | V002__Popular_Tabela de_Unidades | 1279644856 |     root     | 2018-02-06 09:18:00.0 |       220      |  true  |


## Links importantes

https://flywaydb.org/

https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
