package br.com.itau.brainWithoutPrice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.brainWithoutPrice.dao.Itmn_alarmeDAO;
import br.com.itau.brainWithoutPrice.dao.Itmn_eventoDAO;
import br.com.itau.brainWithoutPrice.model.Intervalo;
import br.com.itau.brainWithoutPrice.model.Itmn_alarme;
import br.com.itau.brainWithoutPrice.model.Itmn_evento;
import br.com.itau.brainWithoutPrice.model.RelatorioAlarme;

@CrossOrigin("*")
@RestController
public class Itmn_eventoController {
	
	@Autowired
	private Itmn_eventoDAO dao;
	@Autowired
	private Itmn_alarmeDAO dao_alarme;
	
	@GetMapping("/eventos")
	public ResponseEntity<ArrayList<Itmn_evento>> exibirTodosItmn_eventos(){
		
		ArrayList<Itmn_evento> lista = (ArrayList<Itmn_evento>) dao.findAll();
		
		if(lista.size() == 0) {
			return ResponseEntity.status(403).build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/evento/{id}")
	public ResponseEntity<Itmn_evento> getItmn_eventoId(@PathVariable int id){
		Itmn_evento resposta = dao.findById(id).orElse(null);
		if(resposta == null) {
			return ResponseEntity.status(403).build(); 
		}
		else {
			return ResponseEntity.ok(resposta);
		} 
	} 
	
	@PostMapping("/evento/intervalo")
	public ResponseEntity<ArrayList<Itmn_evento>> getCadastroIntervalo(@RequestBody Intervalo intervalo){
		ArrayList<Itmn_evento> lista = dao.getByNum_seq(intervalo.getInicio(), intervalo.getFim());
		if(lista.size()==0) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping("/alarme/totaldata")
    public ResponseEntity<ArrayList<RelatorioAlarme>> alarmesIntervalo(@RequestBody Intervalo intervalo){
		ArrayList<Itmn_alarme> lista_alarmes = (ArrayList<Itmn_alarme>) dao_alarme.findAll();
		ArrayList<RelatorioAlarme> saida = new ArrayList<RelatorioAlarme>();
		RelatorioAlarme objeto = null;for (Itmn_alarme a : lista_alarmes) {    
			objeto = new RelatorioAlarme();    objeto.setAlarme(a.getNome());    
			objeto.setQtde(dao.getByAlarme(intervalo.getInicio(), intervalo.getFim(),a.getId_alarme()));    
			saida.add(objeto);}
		if (saida.size()==0) {    
				return ResponseEntity.notFound().build();}
			else {    
				return ResponseEntity.ok(saida);
			}    
		} 
	
}
