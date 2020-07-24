package br.com.itau.brainWithoutPrice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.brainWithoutPrice.dao.Itmn_equipamentoDAO;
import br.com.itau.brainWithoutPrice.model.Itmn_equipamento;

@CrossOrigin("*")
@RestController


public class Itmn_equipamentoController {

	@Autowired
	private Itmn_equipamentoDAO dao;
	
	@GetMapping("/equipamentos")
	public ResponseEntity<ArrayList<Itmn_equipamento>> exibirTodosItmn_equipamentos(){
		
		ArrayList<Itmn_equipamento> lista = (ArrayList<Itmn_equipamento>) dao.findAll();
		
		if(lista.size() == 0) {
			return ResponseEntity.status(403).build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/equipamento/{id}")
	public ResponseEntity<Itmn_equipamento> getItmn_equipamentoId(@PathVariable int id){
		Itmn_equipamento resposta = dao.findById(id).orElse(null);
		if(resposta == null) {
			return ResponseEntity.status(403).build(); 
		}
		else {
			return ResponseEntity.ok(resposta);
		} 
	} 
	
}
