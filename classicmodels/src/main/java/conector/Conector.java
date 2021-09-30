package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import conector.Conector;

public class Conector {
	private static Connection con = null;
	private static final String conUrl = "jdbc:mariadb://localhost:3336/classicmodels?user=root&password=123456"
			+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static Connection getConnection() {

		try {

			if (con == null) {
				con = DriverManager.getConnection(Conector.conUrl);
				System.out.println("Conexión realizada correctamente");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return con;
	}
	
	public static void close() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
}
