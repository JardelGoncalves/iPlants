package beans;

import java.sql.Date;

public class Usuario {
	private int id;
	private boolean nivel_acesso;
	private String nome, email, senha;
	private Date created;
	
	public boolean getNivel_acesso() {
		return nivel_acesso;
	}
	public void setNivel_acesso(boolean nivel_acesso) {
		this.nivel_acesso = nivel_acesso;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

}
