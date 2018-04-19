package local.controller;


import local.model.Conteudo;
import local.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/conteudos")
public class ConteudoController {

	@Autowired
	private ConteudoRepository conteudoDAO;
	
	@GetMapping
	public List<Conteudo> listar(){
		return conteudoDAO.findAll();
	}

	/*
	O @Valid ativa a validação especificada na model, sem "estourar" erro em servidor.
	 */
	@PostMapping
	public ResponseEntity<Conteudo> salvar(@Valid @RequestBody Conteudo conteudo, HttpServletResponse response) {
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
}
