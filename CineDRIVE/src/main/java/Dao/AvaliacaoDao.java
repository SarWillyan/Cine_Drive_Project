package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			
			preparedStatement.executeUpdate();
			
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
		return null;
	}

}
