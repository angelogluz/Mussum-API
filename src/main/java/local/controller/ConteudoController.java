package local.controller;


import local.model.Conteudo;
import local.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import local.repository.ConteudoRepository;

@RestController
@RequestMapping("/conteudos")
public class ConteudoController {

	@Autowired
	private ConteudoRepository conteudoDAO;
	
	@GetMapping
	public List<Conteudo> listar(){
		return conteudoDAO.findAll();
	}
	
	@PostMapping
	//@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<Conteudo> salvar(@RequestBody Conteudo conteudo, HttpServletResponse response) {
		Conteudo uc = conteudoDAO.save(conteudo);
		return new ResponseEntity<Conteudo>(uc, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/{id}")
	public Conteudo buscar (@PathVariable int id) {
		return conteudoDAO.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable int id) {
		Conteudo uc = conteudoDAO.findById(id).get();
		conteudoDAO.delete(uc);
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
