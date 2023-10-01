package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.MySqlConnection;
import Model.Filme;

public class FilmeDao implements CRUD_Filme {

	private static Connection connection = MySqlConnection.createConnection();

	private static String sql;

	@Override
	public void create(Filme filme) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int filmeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Filme> findByName(String nome) {

		return null;
	}

	@Override
	public List<Filme> findByGender(String genero) {
		sql = "SELECT f.* "
				+ "FROM filme AS f "
				+ "INNER JOIN generos_filme AS gf ON f.id = gf.id_filme "
				+ "INNER JOIN genero AS g ON gf.id_genero = g.id "
				+ "WHERE g.nome = ?";

		List<Filme> filmes = new ArrayList<Filme>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setString(1, genero);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Filme filme = new Filme();
				filme.setId(resultSet.getInt("id"));
				filme.setTitulo(resultSet.getString("titulo"));
				filme.setAno(resultSet.getInt("ano"));
				filme.setImagem_url(resultSet.getString("imagem_url"));
				filme.setNota(resultSet.getFloat("nota"));
				filme.setTempo(resultSet.getInt("tempo"));
				filme.setSinopse(resultSet.getString("sinopse"));

				filmes.add(filme);
			}

			System.out.println("--correct find filmes de " + genero);
			return filmes;
		} catch (SQLException e) {
			System.out.println("--incorrect find filmes de " + genero + ". " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Filme> findMovies() {
		sql = "SELECT * FROM filme";

		List<Filme> filmes = new ArrayList<Filme>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Filme filme = new Filme();
				filme.setId(resultSet.getInt("id"));
				filme.setTitulo(resultSet.getString("titulo"));
				filme.setAno(resultSet.getInt("ano"));
				filme.setImagem_url(resultSet.getString("imagem_url"));
				filme.setNota(resultSet.getFloat("nota"));
				filme.setTempo(resultSet.getInt("tempo"));
				filme.setSinopse(resultSet.getString("sinopse"));

				filmes.add(filme);
			}

			System.out.println("--correct find filmes");
			return filmes;
		} catch (SQLException e) {
			System.out.println("--incorrect find filmes. " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Filme> findTopMovies() {
		sql = "SELECT * "
			+ "FROM filme "
			+ "ORDER BY nota DESC "
			+ "LIMIT 10";

		List<Filme> filmes = new ArrayList<Filme>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Filme filme = new Filme();
				filme.setId(resultSet.getInt("id"));
				filme.setTitulo(resultSet.getString("titulo"));
				filme.setAno(resultSet.getInt("ano"));
				filme.setImagem_url(resultSet.getString("imagem_url"));
				filme.setNota(resultSet.getFloat("nota"));
				filme.setTempo(resultSet.getInt("tempo"));
				filme.setSinopse(resultSet.getString("sinopse"));

				filmes.add(filme);
			}

			System.out.println("--correct find top filmes");
			return filmes;
		} catch (SQLException e) {
			System.out.println("--incorrect find top filmes. " + e.getMessage());
			return null;
		}
	}

	@Override
	public void update(Filme usuario) {
		// TODO Auto-generated method stub

	}

}
