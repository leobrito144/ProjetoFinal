package br.com.itau.brainWithoutPrice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.brainWithoutPrice.dao.Itmn_alarmeDAO;
import br.com.itau.brainWithoutPrice.model.Itmn_alarme;

@CrossOrigin("*")
@RestController


public class Itmn_alarmeController {
	
	@Autowired
	private Itmn_alarmeDAO dao;
	
	@GetMapping("/alarmes")
	public ResponseEntity<ArrayList<Itmn_alarme>> exibirTodosItmn_alarmes(){
		
		ArrayList<Itmn_alarme> lista = (ArrayList<Itmn_alarme>) dao.findAll();
		
		if(lista.size() == 0) {
			return ResponseEntity.status(403).build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/alarme/{id}")
	public ResponseEntity<Itmn_alarme> getItmn_alarmeId(@PathVariable int id){
		Itmn_alarme resposta = dao.findById(id).orElse(null);
		if(resposta == null) {
			return ResponseEntity.status(403).build(); 
		}
		else {
			return ResponseEntity.ok(resposta);
		} 
	} 
}
