package local.controller;

import local.model.Unidade;
import local.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeRepository unidadeDAO;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_PESQUISAR_UNIDADE')")
    public List<Unidade> listar() {
        return unidadeDAO.findAll();
    }

    /*
    O @Valid ativa a validação especificada na model, sem "estourar" erro em servidor.
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_CADASTRAR_UNIDADE')")
    public ResponseEntity<Unidade> salvar(@Valid @RequestBody Unidade unidade) {
        Unidade uc = unidadeDAO.save(unidade);
        return new ResponseEntity<Unidade>(uc, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_PESQUISAR_UNIDADE')")
    public Unidade buscar(@PathVariable int id) {
        return unidadeDAO.findById(id).get();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_REMOVER_UNIDADE')")
    public void remover(@PathVariable int id) {
        Unidade uc = unidadeDAO.findById(id).get();
        unidadeDAO.delete(uc);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_CADASTRAR_UNIDADE')")
    public ResponseEntity<Unidade> editar(@Valid @RequestBody Unidade unidade) {
        Unidade uc = unidadeDAO.save(unidade);
        return new ResponseEntity<Unidade>(uc, HttpStatus.OK);

    }

}
