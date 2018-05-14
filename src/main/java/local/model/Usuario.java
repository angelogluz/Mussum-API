package local.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario extends GenericModel{


    private String email;
    private String senha;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "id_usuario")
            , inverseJoinColumns = @JoinColumn(name = "id_permissao"))
    private List<Permissao> permissoes;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        if (!super.equals(o)) return false;

        Usuario usuario = (Usuario) o;

        if (!email.equals(usuario.email)) return false;
        return senha.equals(usuario.senha);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + senha.hashCode();
        return result;
    }
}
