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
import local.repository.FaculdadeRepository;

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
	//@ResponseStatus(code=HttpStatus.CREATED)
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

	/**
	@PostConstruct
	public void popularDB() {
		Aula uc1 = new Aula();
		uc1.setNome("Algoritmos III");
		Aula uc2 = new Aula();
		uc2.setNome("Algoritmos I");
		aulaDAO.saveAll(Arrays.asList(uc1,uc2));
	}
	*/
}
