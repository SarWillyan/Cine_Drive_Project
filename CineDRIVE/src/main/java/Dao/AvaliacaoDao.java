package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.MySqlConnection;
import Model.Avaliacao;

public class AvaliacaoDao implements CRUD_Avaliacao {

	private static Connection connection = MySqlConnection.createConnection();

	private static String sql;

	@Override
	public void createOrUpdate(Avaliacao avaliacao) {
		sql = "{call inserir_ou_atualizar_avaliacao( ?, ?, ?)}";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setInt(1, avaliacao.getId_filme());
			preparedStatement.setInt(2, avaliacao.getId_usuario());
			preparedStatement.setInt(3, avaliacao.getNota());
			
			preparedStatement.execute();
			
			System.out.println("--correct insert vote on database. ");	
		} catch (SQLException e) {
			System.out.println("--incorrect insert vote on database. " + e.getMessage());
		}

	}

	@Override
	public void delete(int avaliacaoId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer countNumberOfVotes(int filmeId) {
		sql = "SELECT count(*) as votos "
				+ "FROM avaliacao "
				+ "WHERE id_filme = ?";
		
		int votos = 0;
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setInt(1, filmeId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				votos = resultSet.getInt("votos");
			}
			
			System.out.println("--correct find number of votes.");
			return votos;
		} catch (SQLException e) {
			System.out.println("--incorrect find number of votes. " + e.getMessage());
			return votos;
		}
	
	}

}
