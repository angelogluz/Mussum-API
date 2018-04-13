# Hibernate - Tratando com tabelas relacionadas
Algumas anotações já foram vistas para que nossa model seja "entendida" pelo nosso banco de dados, tais como:

<code>@Column</code> - Que pode ser utilizada para explicitar a referência de um atributo a um campo de uma tabela, ou, principalmente,
quando o nome do campo é diferente do nome do atributo. Quando o nome do campo e do atributo são o mesmo, não é necessária
a utilização da anotação.

Exemplo de uso:

```java
@Entity
public class Unidade extends GenericModel{

	@Column(name = "ativo")
	private boolean ativo;
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
```
A propriedade <b>name</b> define o nome da coluna. 

Através de outras propriedades pode-se definir restrições para a coluna.


## Anotações para relacionamento
Existem 4 principais anotações para definir relacionamento entre tabelas, são elas: <code>@OneToOne</code>, <code>@OneToMany</code>, <code>ManyToOne</code> e <code>@ManyToMany</code>, as quais os nomes as tornam auto-explicativas.

### ManyToOne
Uma das mais utilizadas anotações para relacionamento. Utilizada para a indicar que "Muitos" da classe corrente, estão em "um" da classe referenciada.

Ex.:
```java
@Entity
public class Aula extends GenericModel{

	@ManyToOne
	@JoinColumn(name="unidade_id")
	private Unidade unidade;
	
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
}
```
Note que está sendo indicado que muitas Aulas estão em uma única Unidade.

Ainda é utilizada uma anotação do tipo <code> @JoinColumn </code>, que na propriedade <code>name</code> recebe o nome do campo
no banco de dados que representa a FK.

### ManyToMany
Anotação utilizado para representar relacionamentos N-N.

Ex.:
```java
@Entity
@Table(name = "unidade")
public class Unidade extends GenericModel{

	@Column(name = "ativo")
	private boolean ativo;

	@ManyToMany (targetEntity = local.model.Faculdade.class)
	private List<Faculdade> faculdade;

	@OneToMany(mappedBy = "unidade")
	private List<Aula> aula;


	public List<Faculdade> getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(List<Faculdade> faculdade) {
		this.faculdade = faculdade;
	}

	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@JsonIgnore
	public List<Aula> getAula() {
		return aula;
	}

	public void setAula(List<Aula> aula) {
		this.aula = aula;
	}
}
```

Note que a anotação é colocada em uma Collection, e tem a propriedade <code>targetEntity</code>, que recebe a classe a qual
está sendo representada no array.


## Links importantes

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/


