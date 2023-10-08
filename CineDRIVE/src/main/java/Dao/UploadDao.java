package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
