package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Message;
import beans.Usuario;
import connection.SingleConnection;

public class UsuarioDao {
	private static Connection connection = null;
	
	public UsuarioDao() {
		connection = SingleConnection.getConnection();
	}
	
	// MÉTODO PARA AUTENTICAÇÃO DO USUÁRIO
	public Usuario Authentication(String email, String senha) {
		Usuario usuario = new Usuario();
		try {
			String sql = "SELECT * FROM usuarios WHERE email='"+email+"' AND senha='"+senha+"'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				usuario.setId(result.getInt("id"));
				usuario.setNivel_acesso(result.getBoolean("nivel_acesso"));
				usuario.setNome(result.getString("nome"));
				usuario.setEmail(result.getString("email"));
				usuario.setSenha(result.getString("senha"));
				usuario.setCreated(result.getDate("created"));
				return usuario;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return usuario = null;
	}
	
	// METODO DE CADASTRO DE USUARIO
	public Message CadastrarUsuario(Usuario usuario) {
		Message message = new Message(false, "Ocorreu um erro inesperado ao realizar seu cadastro!");
		try {
			String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getSenha());
			
			statement.execute();
			
			message.setStatus(true);
			message.setContext("Cadastro efetuado com suceeso!<br>Efetue Login para ter acesso ao sistema");
			
			return message;
		} catch (Exception e) { e.printStackTrace();}
		return message;
	}
	
	public List<Usuario> getAll(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			String sql = "SELECT * FROM usuarios";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setNome(result.getString("nome"));
				usuario.setEmail(result.getString("email"));
				usuario.setSenha(result.getString("senha"));
				usuario.setNivel_acesso(result.getBoolean("nivel_acesso"));
				usuario.setId(result.getInt("id"));
				usuario.setCreated(result.getDate("created"));
				
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return usuarios;
	}

}
