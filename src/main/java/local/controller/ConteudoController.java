package local.controller;


import local.model.Conteudo;
import local.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/conteudos")
public class ConteudoController {

    @Autowired
    private ConteudoRepository conteudoDAO;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_CADASTRAR_CONTEUDO')")
    public List<Conteudo> listar() {
        return conteudoDAO.findAll();
    }

    /*
    O @Valid ativa a validação especificada na model, sem "estourar" erro em servidor.
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_CADASTRAR_CONTEUDO')")
    public ResponseEntity<Conteudo> salvar(@Valid @RequestBody Conteudo conteudo) {
        Conteudo uc = conteudoDAO.save(conteudo);
        return new ResponseEntity<Conteudo>(uc, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Conteudo buscar(@PathVariable int id) {
        return conteudoDAO.findById(id).get();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_PESQUISAR_CONTEUDO')")
    public void remover(@PathVariable int id) {
        Conteudo uc = conteudoDAO.findById(id).get();
        conteudoDAO.delete(uc);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_CADASTRAR_CONTEUDO')")
    public ResponseEntity<Conteudo> editar(@Valid @RequestBody Conteudo conteudo) {
        Conteudo content = conteudoDAO.save(conteudo);
        return new ResponseEntity<Conteudo>(content, HttpStatus.OK);

    }
}
