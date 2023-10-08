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
		sql = "INSERT INTO filme (titulo, ano, imagem_url, tempo, sinopse) "
				+ "VALUES ( ?, ?, ?, ?, ?)";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setString(1, filme.getTitulo());
			preparedStatement.setInt(2, filme.getAno());
			preparedStatement.setString(3, filme.getImagem_url());
			preparedStatement.setInt(4, filme.getTempo());
			preparedStatement.setString(5, filme.getSinopse());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database.");
			
		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}
	}

	@Override
	public void delete(int filmeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Filme> findByName(String nome) {
		sql = "SELECT * FROM filme WHERE titulo LIKE ?";

		List<Filme> filmes = new ArrayList<Filme>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setString(1, "%" + nome + "%");

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

			System.out.println("--correct find filmes by name");
			return filmes;
		} catch (SQLException e) {
			System.out.println("--incorrect find filmes by name. " + e.getMessage());
			return null;
		}
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
	public Filme findById(int filmeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int findLastMovie() {
		sql = "SELECT * FROM filme "
				+ "ORDER BY id DESC "
				+ "LIMIT 1;";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			ResultSet resultSet = preparedStatement.executeQuery();

			int id = 0;
			while (resultSet.next()) {
				id = resultSet.getInt("id");
			}

			System.out.println("--correct find last movie");
			return id;
		} catch (SQLException e) {
			System.out.println("--incorrect find last movie. " + e.getMessage());
			return 0;
		}
	}

	@Override
	public void update(int filmeId) {
		// TODO Auto-generated method stub
		
	}

}
