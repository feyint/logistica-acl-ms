package com.logistica.commonacl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.logistica.commonacl.entity.Usuario;
import com.logistica.commonacl.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CommonController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	// private final Logger log = LoggerFactory.getLogger(ClienteRestController.class);

	@GetMapping("/usuarios")
	public List<Usuario> index() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable Integer id) {

		Usuario cliente = null;
		Map<String, Object> response = new HashMap<>();

		try {
			cliente = usuarioRepository.findById(id).orElse(null);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new Usuario();
		}

		if(cliente == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new Usuario();
		}

		return cliente;
	}
	

}
