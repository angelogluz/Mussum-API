package local.model;

import javax.persistence.Entity;

@Entity
public class Faculdade extends GenericModel{
    private String cnpj;



    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
