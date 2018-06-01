package local.controller;


import local.model.Curso;
import local.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoDAO;
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_PESQUISAR_CURSO')")
	public List<Curso> listar(){
		return cursoDAO.findAll();
	}

	/*
	O @Valid ativa a validação especificada na model, sem "estourar" erro em servidor.
	 */
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_CADASTRAR_CURSO')")
	//@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Curso> salvar(@Valid @RequestBody Curso curso) {
		Curso uc = cursoDAO.save(curso);
		return new ResponseEntity<Curso>(uc, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_PESQUISAR_CURSO')")
	public Curso buscar (@PathVariable int id) {
		return cursoDAO.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_PESQUISAR_CURSO')")
	public void remover(@PathVariable int id) {
		Curso uc = cursoDAO.findById(id).get();
		cursoDAO.delete(uc);
	}

	@PutMapping
	@PreAuthorize("hasAnyRole('ROLE_CADASTRAR_CURSO')")
	public ResponseEntity<Curso> editar(@Valid @RequestBody Curso curso) {
		Curso course = cursoDAO.save(curso);
		return new ResponseEntity<Curso>(course, HttpStatus.OK);
	}
}
