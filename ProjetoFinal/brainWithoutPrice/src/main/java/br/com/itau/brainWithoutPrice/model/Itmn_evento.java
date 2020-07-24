package br.com.itau.brainWithoutPrice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn_evento")

public class Itmn_evento {
	@Column(name="num_seq")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num_seq;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="data_evt")
	private Date data_evt;

	@JsonIgnoreProperties("itmn_evento")
	@ManyToOne
	private Itmn_alarme itmn_alarme;
	
	@JsonIgnoreProperties("itmn_evento")
	@ManyToOne
	private Itmn_equipamento itmn_equipamento;


	
	
	public int getNum_seq() {
		return num_seq;
	}

	public Itmn_evento() {
		super();
	}

	public Itmn_evento(int num_seq, Date data_evt, Itmn_alarme itmn_alarme, Itmn_equipamento itmn_equipamento) {
		super();
		this.num_seq = num_seq;
		this.data_evt = data_evt;
		this.itmn_alarme = itmn_alarme;
		this.itmn_equipamento = itmn_equipamento;
	}

	public void setNum_seq(int num_seq) {
		this.num_seq = num_seq;
	}

	public Date getData_evt() {
		return data_evt;
	}

	public void setData_evt(Date data_evt) {
		this.data_evt = data_evt;
	}

	public Itmn_alarme getItmn_alarme() {
		return itmn_alarme;
	}

	public void setItmn_alarme(Itmn_alarme itmn_alarme) {
		this.itmn_alarme = itmn_alarme;
	}

	public Itmn_equipamento getItmn_equipamento() {
		return itmn_equipamento;
	}

	public void setItmn_equipamento(Itmn_equipamento itmn_equipamento) {
		this.itmn_equipamento = itmn_equipamento;
	}
	
	
}
