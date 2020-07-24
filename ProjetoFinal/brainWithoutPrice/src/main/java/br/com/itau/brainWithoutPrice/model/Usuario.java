package br.com.itau.brainWithoutPrice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="usuarios")

	public class Usuario {
		@Column(name="id")
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column (name="nome", length=40)
		private String nome;
		
		@Column (name="racf", length= 7)
		private String racf;
		
		@Column (name="senha", length= 20)
		private String senha;
		
		@Column (name="foto", length= 100)
		private String foto;
		
		@Column (name="email", length=30)
		private String email;
		
		
		public Usuario(int id, String nome, String racf, String senha, String foto, String email) {
			super();
			this.id = id;
			this.nome = nome;
			this.racf = racf;
			this.senha = senha;
			this.foto = foto;
			this.email = email;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAll() {
			return
					"id......:"+id+"\n"+
					"Nome....:"+nome+"\n"+
					"RACF..:"+racf+"\n"+
					"Senha...:"+senha+"\n"+
					"Foto....:"+foto+"\n";
		}
		
		public void setAll(int id, String nome, String racf, String foto, String senha) {
			this.id = id;
			this.nome = nome;
			this.racf = racf;
			this.foto = foto;
			this.senha = senha;
		}
		
		public Usuario() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getRacf() {
			return racf;
		}

		public void setRacf(String racf) {
			this.racf = racf;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}
		
		public String getSenha() {
			return senha;
		}

		
		public void setSenha(String senha) {
			this.senha = senha;
		}

		
}
