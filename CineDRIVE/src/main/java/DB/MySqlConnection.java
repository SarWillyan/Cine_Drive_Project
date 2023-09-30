package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/cine_drive";
	// usuário
	private static final String user = "root";
	// senha
	private static final String passoword = "159753";

	public static Connection createConnection() {
		
		// Verifica se o driver jdbc existe
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Found");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found. " + e.getMessage());
		}
		
		// Conecta ao bd escohido
		try {
			Connection connection = DriverManager.getConnection(url, user, passoword);
			System.out.println("Connected to database");
			return connection;
		} catch (SQLException e) {
			System.out.println("Not connected to database. " + e.getMessage());
			return null;
		}
	}
}
