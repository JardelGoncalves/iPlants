package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
	private static String URL = "jdbc:postgresql://localhost/iplants-db?autoReconnect=true";
	private static String USER = "postgres";
	private static String PASS = "postgres";
	private static Connection connection = null;
	
	static {
		connect();
	}
	
	public SingleConnection() {
		connect();
	}
	
	public static void connect() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(URL, USER, PASS);
				connection.setAutoCommit(false);
			}
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Erro ao carregar Driver!");
		}catch (SQLException e1) {
			throw new RuntimeException("Erro ao se conectar ao banco de dados");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
