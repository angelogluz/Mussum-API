package local.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aula extends GenericModel{

	@ManyToOne //Relacionamento de muitos para um
	@JoinColumn(name="unidade_id") //Definindo a coluna que vai ser relacionada
	private Unidade unidade; //Instanciando a classe que sera relacionada
	
	//Get and Set 
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Aula nome - "+getNome();
	}
}
