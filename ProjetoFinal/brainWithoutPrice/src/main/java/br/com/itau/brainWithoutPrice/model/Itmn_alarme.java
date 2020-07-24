package br.com.itau.brainWithoutPrice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn_alarme")

public class Itmn_alarme {
	@Column(name="id_alarme")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_alarme;
	@Column(name="nome", length=100)
	private String nome;
	@Column(name="descricao", length=200)
	private String descricao;
	
	@JsonIgnoreProperties("itmn_alarme")
	@OneToMany(mappedBy="itmn_alarme",cascade=CascadeType.ALL)
	private List<Itmn_evento> itmn_evento;
	

	public Itmn_alarme() {
		super();
	}

	public Itmn_alarme(int id_alarme, String nome, String descricao, List<Itmn_evento> itmn_evento) {
		super();
		this.id_alarme = id_alarme;
		this.nome = nome;
		this.descricao = descricao;
		this.itmn_evento = itmn_evento;
	}

	public int getId_alarme() {
		return id_alarme;
	}

	public void setId_alarme(int id_alarme) {
		this.id_alarme = id_alarme;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Itmn_evento> getItmn_evento() {
		return itmn_evento;
	}

	public void setItmn_evento(List<Itmn_evento> itmn_evento) {
		this.itmn_evento = itmn_evento;
	}
	
	
	
}
