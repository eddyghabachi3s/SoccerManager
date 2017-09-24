package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jogo_v001";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "mysql";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DATABASE_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException ex) {
			System.err.println("Caught Exception: " + ex.getMessage());
		}
		return con;
	}

}