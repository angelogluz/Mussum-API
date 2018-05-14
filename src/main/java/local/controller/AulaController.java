package local.controller;


import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import local.model.Conteudo;
import local.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import local.model.Aula;

@RestController
@RequestMapping("/aulas")
public class AulaController {

	@Autowired
	private AulaRepository aulaDAO;
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_PESQUISAR_AULA')")
	public List<Aula> listar(){
		return aulaDAO.findAll();
	}
	/*
	O @Valid ativa a validação especificada na model, sem "estourar" erro em servidor.
	 */
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_CADASTRAR_AULA')")
	public ResponseEntity<Aula> salvar(@Valid @RequestBody Aula aula) {
		Aula uc = aulaDAO.save(aula);
		return new ResponseEntity<Aula>(uc, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_PESQUISAR_AULA')")
	public Aula buscar (@PathVariable int id) {
		return aulaDAO.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_REMOVER_AULA')")
	public void remover(@PathVariable int id) {
		Aula uc = aulaDAO.findById(id).get();
		aulaDAO.delete(uc);
	}
	@PutMapping
	@PreAuthorize("hasAnyRole('ROLE_CADASTRAR_AULA')")
	public ResponseEntity<Aula> editar(@Valid @RequestBody Aula aula) {
		Aula lesson = aulaDAO.save(aula);
		return new ResponseEntity<Aula>(lesson, HttpStatus.OK);

	}
}
