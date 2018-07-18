package br.com.ufcg.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufcg.springboot.exception.RegisterNotFoundException;
import br.com.ufcg.springboot.model.Usuario;
import br.com.ufcg.springboot.model.Usuario;
import br.com.ufcg.springboot.repository.TodoRepository;
import br.com.ufcg.springboot.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository userRepository;

	public List<Usuario> getAll() {
		return userRepository.findAll();
	}

	public Usuario getById(Long matricula) {
		Optional<Usuario> optUser = userRepository.findById(matricula);

		if (!optUser.isPresent()) {
			throw new RegisterNotFoundException("Todo don't exists");
		}

		return optUser.get();
	}

	public Usuario save(Usuario todo) {
		userRepository.save(todo);
		return todo;
	}

	public Usuario update(Usuario todo, Long matricula) {
		Optional<Usuario> optUser = userRepository.findById(matricula);

		if (!optUser.isPresent()) {
			throw new RegisterNotFoundException("Todo don't exists");
		}

		Usuario newUser = optUser.get();
		newUser.setNome(todo.getNome());

		userRepository.save(newUser);

		return newUser;
	}

	public Usuario delete(Long matricula) {
		Optional<Usuario> optUser = userRepository.findById(matricula);

		if (!optUser.isPresent()) {
			throw new RegisterNotFoundException("Todo don't exists");
		}

		Usuario user = optUser.get();
		userRepository.delete(user);

		return user;
	}
}