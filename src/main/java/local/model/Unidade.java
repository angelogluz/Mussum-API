package local.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "unidade")
public class Unidade extends GenericModel{

	@Column(name = "ativo")
	private boolean ativo;

	@ManyToMany (targetEntity = local.model.Curso.class)
	private List<Curso> curso;

	@OneToMany(mappedBy = "unidade")
	private List<Aula> aula;


	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
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
