package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.MySqlConnection;
import Model.Comentario;

public class ComentarioDao implements CRUD_Comentario {

	private static Connection connection = MySqlConnection.createConnection();

	private static String sql;
	
	@Override
	public void create(Comentario comentario) {
		sql = "INSERT INTO comentario (id_filme, id_usuario, comentario)"
				+ " VALUES (?, ?, ?) ";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			
			preparedStatement.setInt(1, comentario.getId_filme());
			preparedStatement.setInt(2, comentario.getId_usuario());
			preparedStatement.setString(3, comentario.getComentario());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insertion on data base.");
			
		} catch (SQLException e) {
			System.out.println("--incorrect insertion on data base. " + e.getMessage());
		}

	}

	@Override
	public List<Comentario> findByMovie(int filmeId) {
		sql = "SELECT * FROM comentario WHERE id_filme = ? ";
		
		List<Comentario> comentarios = new ArrayList<Comentario>();
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setInt(1, filmeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Comentario comentario = new Comentario();
				
				comentario.setId_filme(resultSet.getInt("id_filme"));
				comentario.setId_usuario(resultSet.getInt("id_usuario"));
				comentario.setComentario(resultSet.getString("comentario"));
				comentario.setData_comentario(resultSet.getString("data_comentario"));
				
				comentarios.add(comentario);
			}
			
			System.out.println("--correct find on comentarios.");
			return comentarios;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find on comentarios. " + e.getMessage());
			return null;
		}
	}

}
