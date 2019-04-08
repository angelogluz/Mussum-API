package local.controller;


import local.model.Aula;
import local.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaRepository aulaDAO;

    /**
     * Metódo para pesquisar aulas que contenham o mesmo nome
     * @return  retorna uma lista de todas as aulas com o nome pesquisado
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_PESQUISAR_AULA')")
    public List<Aula> listar() {
        return aulaDAO.findAll();
    }

    /**
     * Metódo que busca salvar uma aula no banco de dados
     * @param aula objeto do tipo aula
     * @return retorna uma entidade no status created
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_CADASTRAR_AULA')")
    public ResponseEntity<Aula> salvar(@Valid @RequestBody Aula aula) {
        Aula uc = aulaDAO.save(aula);
        return new ResponseEntity<Aula>(uc, HttpStatus.CREATED);
    }
/**
 * Método que busca uma aula especifica
 * @param id id do objeto do tipo aula
 * @return retorna a aula que contenha o id especifico
 */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_PESQUISAR_AULA')")
    public Aula buscar(@PathVariable int id) {
        return aulaDAO.findById(id).get();
    }
/**
 * Método que deleta uma aula especifica
 * @param id id do objeto do tipo aula
 */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_REMOVER_AULA')")
    public void remover(@PathVariable int id) {
        Aula uc = aulaDAO.findById(id).get();
        aulaDAO.delete(uc);
    }
/**
 * Método que permite a edição de uma aula
 * @param aula objeto do tipo aula
 * @return retorna uma nova entidade com status ok
 */
    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_CADASTRAR_AULA')")
    public ResponseEntity<Aula> editar(@Valid @RequestBody Aula aula) {
        Aula lesson = aulaDAO.save(aula);
        return new ResponseEntity<Aula>(lesson, HttpStatus.OK);

    }
}
