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
@Table(name="Itmn_equipamento")

public class Itmn_equipamento {
	@Column(name="id_equip")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_equip;
	@Column(name="hostname", length=50)
	private String hostname;
	@Column(name="ipaddr", length=15)
	private String ipaddr;
	
	@JsonIgnoreProperties("itmn_equipamento")
	@OneToMany(mappedBy="itmn_equipamento",cascade=CascadeType.ALL)
	private List<Itmn_evento> itmn_evento;

	public Itmn_equipamento(int id_equip, String hostname, String ipaddr, List<Itmn_evento> itmn_evento) {
		super();
		this.id_equip = id_equip;
		this.hostname = hostname;
		this.ipaddr = ipaddr;
		this.itmn_evento = itmn_evento;
	}

	public Itmn_equipamento() {
		super();
	}

	public int getId_equip() {
		return id_equip;
	}

	public void setId_equip(int id_equip) {
		this.id_equip = id_equip;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public List<Itmn_evento> getItmn_evento() {
		return itmn_evento;
	}

	public void setItmn_evento(List<Itmn_evento> itmn_evento) {
		this.itmn_evento = itmn_evento;
	}
	
	
	
}
