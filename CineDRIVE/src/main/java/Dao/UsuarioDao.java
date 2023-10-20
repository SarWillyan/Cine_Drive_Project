package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DB.MySqlConnection;
import Model.Usuario;

public class UsuarioDao implements CRUD_Usuario {

	// cria a conecção
	private static Connection connection = MySqlConnection.createConnection();
	// recebe a linha de comando sql
	private static String sql;

	@Override
	public void create(Usuario usuario) {
		sql = "INSERT INTO usuario (email, senha, nome) VALUES (?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, usuario.getEmail());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3, usuario.getNome());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");
		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}

	}

	@Override
	public void delete(int usuarioId) {
		// TODO Auto-generated method stub

	}
	
	/*ARRUMAR ESSE MÉTODO -- NÃO ESTÁ FUNCIONAL, SÓ COMECEI --*/
	@Override
	public List<Usuario> findTopUsers() {
		sql = "SELECT u.nome AS nome_usuario, COUNT(up.id_usuario) AS numero_uploads "
				+ "FROM usuario u "
				+ "LEFT JOIN uploads up ON u.id = up.id_usuario "
				+ "GROUP BY u.nome "
				+ "ORDER BY numero_uploads DESC "
				+ "LIMIT 10";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Usuario usuario = new Usuario();
			while (resultSet.next()) {
				usuario.setNome(resultSet.getString("nome_usuario"));
			} 

			System.out.println("--correct find usuario by email");
			
			return null;
		} catch (SQLException e) {
			System.out.println("--incorrect find usuario by email " + e.getMessage());
			return null;
		}
	}

	@Override
	public Usuario findByEmail(String email) {
		sql = "SELECT * FROM usuario WHERE email = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Usuario usuario = new Usuario();
			if (resultSet.next()) {
				usuario.setId(resultSet.getInt("id"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setSenha(resultSet.getString("senha"));
			} 

			System.out.println("--correct find usuario by email");
			
			return usuario;
		} catch (SQLException e) {
			System.out.println("--incorrect find usuario by email " + e.getMessage());
			return null;
		}
	}

	@Override
	public void update(Usuario usuario) {
		
	}

	@Override
	public Usuario findById(int usuarioId) {
		sql = "SELECT * FROM usuario WHERE id = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, usuarioId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Usuario usuario = new Usuario();
			if (resultSet.next()) {
				usuario.setId(resultSet.getInt("id"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setSenha(resultSet.getString("senha"));
			} 

			System.out.println("--correct find usuario by email");
			
			return usuario;
		} catch (SQLException e) {
			System.out.println("--incorrect find usuario by email " + e.getMessage());
			return null;
		}
	}

}
