package local.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


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

import local.model.Unidade;
import local.repository.UnidadeRepository;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	@Autowired
	private UnidadeRepository unidadeDAO;
	
	@GetMapping
	public List<Unidade> listar(){
		return unidadeDAO.findAll();
	}
	/*
	O @Valid ativa a validação especificada na model, sem "estourar" erro em servidor.
	 */
	@PostMapping
	public ResponseEntity<Unidade> salvar(@Valid @RequestBody Unidade unidade, HttpServletResponse response) {
		Unidade uc = unidadeDAO.save(unidade);
		return new ResponseEntity<Unidade>(uc, HttpStatus.CREATED);

	}
	
	@GetMapping("/{id}")
	public Unidade buscar (@PathVariable int id) {
		return unidadeDAO.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable int id) {
		Unidade uc = unidadeDAO.findById(id).get();
		unidadeDAO.delete(uc);
	}

}
