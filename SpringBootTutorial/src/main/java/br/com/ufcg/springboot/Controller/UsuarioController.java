package br.com.ufcg.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufcg.springboot.model.Usuario;
import br.com.ufcg.springboot.model.Usuario;
import br.com.ufcg.springboot.service.TodoService;
import br.com.ufcg.springboot.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	UsuarioService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<Usuario> getAll() {
		return userService.getAll();
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Usuario save(@RequestBody Usuario user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/user/{matricula}", method = RequestMethod.GET)
	public Usuario getById(@PathVariable("matricula") Long matricula) {
		return userService.getById(matricula);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@PathVariable("matricula") Long matricula, @RequestBody Usuario user) {
		Usuario updatedUser = userService.update(user, matricula);
		return new ResponseEntity<Usuario>(updatedUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> delete(@PathVariable("matricula") Long matricula) {
		Usuario user = userService.delete(matricula);
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
}
