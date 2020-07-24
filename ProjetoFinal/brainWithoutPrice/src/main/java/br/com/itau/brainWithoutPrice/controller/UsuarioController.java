package br.com.itau.brainWithoutPrice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.brainWithoutPrice.dao.UsuarioDAO;
import br.com.itau.brainWithoutPrice.model.Usuario;

@CrossOrigin("*")
@RestController

public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> efetuarLogin(@RequestBody Usuario usuario){
		Usuario objeto = dao.findByRacfAndSenha(usuario.getRacf(), usuario.getSenha());
		Usuario objeto2 = dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		if(objeto==null) {
			
			if(objeto2 == null) {
				return ResponseEntity.status(404).build();
			}
			else {
				return ResponseEntity.ok(objeto2);
			}
			
		}
		else {
			return ResponseEntity.ok(objeto);
		}
	}
}
