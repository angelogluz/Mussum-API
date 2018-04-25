package local.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity //Define que esta classe vai ser persistida no Banco de Dados
/**
 * Classe para objetos do tipo Aula, onde serão contidos, valores e métodos para o mesmo.
 * 
 * @author Angelo da Luz
 *
 */
public class Aula extends GenericModel{

	@ManyToOne //Relacionamento de muitos para um
	@JoinColumn(name="unidade_id") //Definindo a coluna que vai ser relacionada
	private Unidade unidade; //Instanciando a classe que sera relacionada
	
	/**
	 * Metodo usado para receber um objeto do tipo unidade.
	 * @return
	 */
	public Unidade getUnidade() {
		return unidade;
	}
	/**
	 * Metodo usado para enviar dados ao objeto do tipo unidade
	 * @param unidade
	 */
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	@Override //Anotação que informa que este metodo é substituto do metodo padrão
	/**
	 * Metodo que Imprime o objeto unidade.
	 */
	public String toString() {
		return "Aula nome - "+getNome();
	}
}
