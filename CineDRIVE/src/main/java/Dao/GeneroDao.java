package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.MySqlConnection;
import Model.Genero;

public class GeneroDao implements CRUD_Genero {

	// cria a conecção
	private static Connection connection = MySqlConnection.createConnection();
	// recebe a linha de comando sql
	private static String sql;

	@Override
	public void create(Genero genero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int generoId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Genero> find() {
		sql = "SELECT * FROM genero";
		
		List<Genero> generos = new ArrayList<Genero>();
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Genero genero = new Genero();
				
				genero.setId(resultSet.getInt("id"));
				genero.setNome(resultSet.getString("nome"));
				
				generos.add(genero);
			}
			
			System.out.println("--correct find genders.");
			return generos;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find genders. " + e.getMessage());
			return null;
		}
	}

}
