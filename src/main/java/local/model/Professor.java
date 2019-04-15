package local.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Professor extends GenericModel {

    @Id
    private int id;
    @NotNull
    private String nome;
    @NotNull
    private String disciplina;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Professor professor = (Professor) o;

        if (id != professor.id) return false;
        if (nome != null ? !nome.equals(professor.nome) : professor.nome != null) return false;
        return disciplina != null ? disciplina.equals(professor.disciplina) : professor.disciplina == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (disciplina != null ? disciplina.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}
