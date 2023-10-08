package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            
			String generos = String.join(",", generosFilme.getIds_generos());
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
		// TODO Auto-generated method stub
		return null;
	}

}
