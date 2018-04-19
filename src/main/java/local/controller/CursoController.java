package local.controller;


import local.model.Curso;
import local.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoDAO;
	
	@GetMapping
	public List<Curso> listar(){
		return cursoDAO.findAll();
	}

	/*
	O @Valid ativa a validação especificada na model, sem "estourar" erro em servidor.
	 */
	@PostMapping
	//@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Curso> salvar(@Valid @RequestBody Curso curso, HttpServletResponse response) {
		Curso uc = cursoDAO.save(curso);
		return new ResponseEntity<Curso>(uc, HttpStatus.CREATED);

	}
	
	@GetMapping("/{id}")
	public Curso buscar (@PathVariable int id) {
		return cursoDAO.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable int id) {
		Curso uc = cursoDAO.findById(id).get();
		cursoDAO.delete(uc);
	}

}
