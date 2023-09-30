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
			System.out.println("--incorrect insert on database " + e.getMessage());
		}

	}

	@Override
	public void delete(int usuarioId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> find(String pesquisa) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

}
