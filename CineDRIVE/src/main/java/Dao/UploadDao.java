package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.MySqlConnection;
import Model.Upload;

public class UploadDao implements CRUD_Upload {

	private static Connection connection = MySqlConnection.createConnection();

	private static String sql;
	
	@Override
	public void create(Upload upload) {
		sql = "INSERT INTO upload (id_usuario, id_filme, video_path) "
				+ "VALUES ( ?, ?, ?) ";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setInt(1, upload.getId_usuario());
			preparedStatement.setInt(2, upload.getId_filme());
			preparedStatement.setString(3, upload.getVideo_path());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database.");

		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}

	}

	@Override
	public List<Upload> findByUserId(int usuarioId) {
		sql = "SELECT * FROM upload WHERE id_usuario = ?";
		
		List<Upload> uploads = new ArrayList<Upload>();
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setInt(1, usuarioId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Upload upload = new Upload();
				
				upload.setId_filme(resultSet.getInt("id_filme"));
				upload.setId_usuario(resultSet.getInt("id_usuario"));
				upload.setData_registro(resultSet.getString("data_registro"));
				
				uploads.add(upload);
			}
			
			System.out.println("--correct find on upload.");
			return uploads;
		} catch (SQLException e) {
			System.out.println("--incorrect find on upload. " + e.getMessage());
			return null;
		}
	}

	@Override
	public Upload findByMovieId(int filmeId) {
		sql = "SELECT * FROM upload WHERE id_filme = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, filmeId);

			ResultSet resultSet = preparedStatement.executeQuery();

			Upload upload = new Upload();
			while (resultSet.next()) {

				upload.setId_filme(resultSet.getInt("id_filme"));
				upload.setId_usuario(resultSet.getInt("id_usuario"));
				upload.setData_registro(resultSet.getString("data_registro"));
				
			}

			System.out.println("--correct find on upload.");
			return upload;
		} catch (SQLException e) {
			System.out.println("--incorrect find on upload. " + e.getMessage());
			return null;
		}
	}
	
	

}
