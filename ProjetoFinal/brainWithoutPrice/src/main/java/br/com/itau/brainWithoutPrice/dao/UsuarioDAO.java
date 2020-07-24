package br.com.itau.brainWithoutPrice.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.brainWithoutPrice.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	
	Usuario findByRacfAndSenha(String racf, String senha);
	Usuario findByEmailAndSenha(String email,String senha);
	Usuario findByEmailOrRacfAndSenha(String email,String racf, String senha);
}