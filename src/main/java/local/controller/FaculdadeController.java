package local.controller;


import local.model.Aula;
import local.model.Faculdade;
import local.repository.FaculdadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("faculdades")
public class FaculdadeController {

	@Autowired
	private FaculdadeRepository faculdadeDAO;
	
	@GetMapping
	public List<Faculdade> listar(){
		return faculdadeDAO.findAll();
	}
	
	@PostMapping
	//@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Faculdade> salvar(@RequestBody Faculdade faculdade, HttpServletResponse response) {
		Faculdade uc = faculdadeDAO.save(faculdade);
		return new ResponseEntity<Faculdade>(uc, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/{id}")
	public Faculdade buscar (@PathVariable int id) {
		return faculdadeDAO.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable int id) {
		Faculdade uc = faculdadeDAO.findById(id).get();
		faculdadeDAO.delete(uc);
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
