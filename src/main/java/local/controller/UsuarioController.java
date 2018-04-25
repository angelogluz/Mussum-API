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

import local.model.Usuario;
import local.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioDAO;

    @GetMapping
    public List<Usuario> listar() {
	return usuarioDAO.findAll();
    }

    /*
	O @Valid ativa a validação especificada na model, sem "estourar" erro em servidor.
     */
    @PostMapping
    public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
	Usuario uc = usuarioDAO.save(usuario);
	return new ResponseEntity<Usuario>(uc, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable int id) {
	return usuarioDAO.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id) {
	Usuario uc = usuarioDAO.findById(id).get();
	usuarioDAO.delete(uc);
    }

}
