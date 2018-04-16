package local.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Curso extends GenericModel{

    private LocalDate dataFundacao;

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
