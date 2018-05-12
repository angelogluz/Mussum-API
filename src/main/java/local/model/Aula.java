package local.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aula extends GenericModel{

	@ManyToOne
	@JoinColumn(name="unidade_id")
	private Unidade unidade;
        
        private Date data;
	
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }
}
