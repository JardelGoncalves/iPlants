package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Message;
import beans.Planta;
import connection.SingleConnection;

public class PlantaDao {
	private static Connection connection = null;
	
	public PlantaDao() {
		connection = SingleConnection.getConnection();
	}
	
	public List<Planta> getAll(int usuario_id){
		List<Planta> lista = new ArrayList<Planta>();
		try {
			String sql = "SELECT * FROM plantas WHERE usuario_id="+usuario_id;
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Planta planta = new Planta();
				
				planta.setId(result.getInt("id"));
				planta.setId_usuario(result.getInt("usuario_id"));
				planta.setNome(result.getString("nome"));
				planta.setDescricao(result.getString("descricao"));
				planta.setFoto(result.getString("foto"));
				planta.setCreated(result.getDate("created"));
				
				lista.add(planta);
			}
		} catch (Exception e) { e.printStackTrace();}
		
		return lista;
	}
	
	public List<Planta> getAllPlants(){
		List<Planta> lista = new ArrayList<Planta>();
		try {
			String sql = "SELECT * FROM plantas";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Planta planta = new Planta();
				
				planta.setId(result.getInt("id"));
				planta.setId_usuario(result.getInt("usuario_id"));
				planta.setNome(result.getString("nome"));
				planta.setDescricao(result.getString("descricao"));
				planta.setFoto(result.getString("foto"));
				planta.setCreated(result.getDate("created"));
				
				lista.add(planta);
			}
		} catch (Exception e) { e.printStackTrace();}
		
		return lista;
	}
	
	public Message SavePlants(Planta planta) {
		Message message = new Message(false, "Ocorreu um erro inesperado. Contate o administrador!");
		try {
			String sql = "INSERT INTO plantas (usuario_id, nome, descricao, foto) VALUES (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, planta.getId_usuario());
			statement.setString(2, planta.getNome());
			statement.setString(3, planta.getDescricao());
			statement.setString(4, planta.getFoto());
			statement.execute();
			
			message.setStatus(true);
			message.setContext("Planta catalogada com sucesso");
		} catch (Exception e) {
			message.setContext("Ocorreu um erro. Verifique os dados inseridos e tente novamente!");
		}
		return message;
	}
	
	public Message DeletePlantas(int planta_id, int usuario_id) {
		Message message = new Message(false, "Ocorreu um erro inesperado. Por favor contate o administrador!");
		try {
			String sql = "DELETE FROM plantas WHERE id="+planta_id+" AND usuario_id="+usuario_id;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			message.setStatus(true);
			message.setContext("Planta removida com sucesso");
		} catch (Exception e) {
			message.setContext("Erro interno ou dados informados inválidos!");
		}
		
		return message;
	}

}
