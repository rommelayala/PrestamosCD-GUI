import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private static String DBUrl="jdbc:mysql://localhost:3306/tiendaDiscos?user=root&password=root";
	private static Connection conDB = null;
	

	// Metodo publico para establecer la cadena de conexion
	public static void setURL(String dburl) {
		DBUrl = dburl;
	}

	/** Devuelve un objeto del tipo Connection con la base de datos
	 * usando singleton
	 *  */
	public static Connection getConexion() {
		// Si no existe la conexion entonces se crea
		if (conDB == null) {
			try {
				// Registamos el driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (Exception e) {
				System.out.println("No se ha encontrado el driver JDBC");
			}

			try {
				// Obtenemos la conexion
				conDB = DriverManager.getConnection(DBUrl);
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("SQLState: " + sqle.getSQLState());
				System.out.println("VendorError: " + sqle.getErrorCode());
			}
		}
		
		
		// Devolvemos un objeto Connection
		return conDB;
	}

	/** Desconecta de la base de datos */

	public static void desconecta() {
		if (conDB != null) {
			try {
				conDB.close();
				conDB=null;
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("SQLState: " + sqle.getSQLState());
				System.out.println("VendorError: " + sqle.getErrorCode());

			}
		}
	}
}