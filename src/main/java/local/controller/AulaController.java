package local.controller;


import java.util.List;
import javax.servlet.http.HttpServletResponse;

import local.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.model.Aula;

@RestController
@RequestMapping("/aulas")
public class AulaController {

	@Autowired
	private AulaRepository aulaDAO;
	
	@GetMapping
	public List<Aula> listar(){
		return aulaDAO.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Aula> salvar(@RequestBody Aula aula, HttpServletResponse response) {
		Aula uc = aulaDAO.save(aula);
		return new ResponseEntity<Aula>(uc, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public Aula buscar (@PathVariable int id) {
		return aulaDAO.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable int id) {
		Aula uc = aulaDAO.findById(id).get();
		aulaDAO.delete(uc);
	}
}
