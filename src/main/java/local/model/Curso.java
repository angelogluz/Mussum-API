package local.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Curso extends GenericModel{

    @NotNull
    private String coordenador;
    private LocalDate dataFundacao;

    public String getCoordenador() { return coordenador; }
    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setCoordenador(String coordenador) { this.coordenador = coordenador; }
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
