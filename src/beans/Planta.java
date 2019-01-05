package beans;

import java.sql.Date;

public class Planta {
	private int id, id_usuario;
	private String nome, descricao, foto;
	private Date created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Nome: "+ this.getNome()+"\nFoto: "+this.getFoto()+"\nUSER_ID: "+this.getId_usuario()+"\nDescricao: "+this.getDescricao();
	}
	
	
	

}
