package local.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Conteudo extends GenericModel{

    @Column(name = "url") //Definindo nome da Coluna no banco de dados
    private String url;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Conteudo nome - "+getNome();
    }
}
