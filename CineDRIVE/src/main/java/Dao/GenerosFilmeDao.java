package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.MySqlConnection;
import Model.GenerosFilme;

public class GenerosFilmeDao implements CRUD_GenerosFilme {
	
	private static Connection connection = MySqlConnection.createConnection();

	private static String sql;

	@Override
	public void create(GenerosFilme generosFilme) {
		sql = "{call InserirGenerosParaFilme(?, ?)}";
		try (PreparedStatement preparedStatement = connection.prepareCall(sql)) {
            
			String generos = String.join(",", generosFilme.getGeneros_name());
            // Defina os parâmetros de entrada
			preparedStatement.setInt(1, generosFilme.getId_filme()); // Substitua filmeId pelo valor desejado
			preparedStatement.setString(2, generos); // Substitua generoNomes pelo valor desejado

            // Execute o procedimento
			preparedStatement.execute();
            
            System.out.println("Procedimento executado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

	@Override
	public List<String> findGendersByMovie(int filmeId) {
		sql = "SELECT g.* "
				+ "FROM genero AS g "
				+ "INNER JOIN generos_filme AS gf ON g.id = gf.id_genero "
				+ "WHERE gf.id_filme = ?";
		List<String> generos = new ArrayList<String>();
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setInt(1, filmeId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				generos.add(resultSet.getString("nome"));
			}
			
			System.out.println("--correct find gender by movie.");
			return generos;	
		} catch (SQLException e) {
			System.out.println("--incorrect find gender by movie. " + e.getMessage());
			return null;
		}
	}

}
