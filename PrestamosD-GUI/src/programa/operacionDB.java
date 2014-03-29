package programa;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class operacionDB extends javax.swing.JFrame {

	static ResultSet res = null;
	static Statement sentenciaSQL;
	static ResultSetMetaData infoTabla = null;
	private static Vector<CDBean> lista = new Vector<>(110);
	private static final long serialVersionUID = 1L;		
	private static String sqlSelect = "SELECT * from discos";

	public static Vector<CDBean> getListaDiscos() {
		String id;
		String titulo;
		String autor;
		String genero;
		String descripcion;

		/**crea el resulset a partir de la consulta sqlselect
		 * muestra por consola el contenido del resulset y llena el vector con esos datos*/
		try {
			sentenciaSQL = ConexionDB.getConexion().createStatement();
			res = sentenciaSQL.executeQuery(sqlSelect);
			res.beforeFirst();
			/**muestra por consola el contenido del resulset y llena el vector con esos datos*/
			try {
				while (res.next()) {

					System.out.println("\nTitulo\tAutor\t\tGenero");

					id=res.getString(1);
					titulo = res.getString("titulo").toString();
					autor = res.getString("autor").toString();
					genero = res.getString("genero").toString();
					descripcion = "";
					System.out.println(titulo + "\t" + autor
							+ "\t" + genero);
					System.out.println("-----------------------");
					// genera disco

					lista.add(new CDBean(titulo, autor, genero, descripcion));
					}
				} catch (SQLException e1) {
				e1.printStackTrace();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		return lista;
		}
			
	/**codigo para uso futuro:
	 *  3 obtiene nuevo Id de la tabla libros */
	private static int getNumeroElementos(String tabla, String ID) {
		Integer id = null;

		try {
			res.last();
			id = res.getInt(ID);

			System.out.println("\nEl ultimo elemento es ->" + id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	/* 4 permite insertar o actualizar la tabla por medio de un String orden */
	private static int grabarFila(String orden) {
		int filas = -1;

		try {
			filas = sentenciaSQL.executeUpdate(orden);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	public static void main(String[] args) {

		/**
		 * 1 Lanza consulta, devuele un resulset, obtiene y guarda informacion
		 * del resultset
		 */
		// res = lanzarSelect(sqlSelect+"discos;");

		/** 2 muestra el contenido del resulset obtenido */
		// mostrarSelect(res);

		/**
		 * 3 obtiene nuevo Id de la tabla libros int
		 * nuevoId=getNuevoID("libros", "codigoLibro");
		 * 
		 * System.out.println("El nuevo ID del libro es "+nuevoId); -fin de 3
		 */

		/**
		 * 4 permite insertar o actualizar la tabla por medio de un String orden
		 * filasAfectadas.- muestra el numero de filas que ha insertado o
		 * actualizado String actualizaGrabaFila =
		 * "INSERT INTO libros VALUES ("+
		 * nuevoId+",0-777-88899-9,'La vida de PI','Melonia','1900-04-12')"
		 * ;//||"UPDATE Libros SET Fecha='2002-01-31' WHERE CodigoLibro=1;"
		 * final int filasAfectadas;
		 * 
		 * filasAfectadas=grabarFila(actualizaGrabaFila);
		 * System.out.println(filasAfectadas
		 * +" Fila(s) afectadas insertando nuevo libro"); -fin de 4
		 */

		/**
		 * 5 anyade nuevo autor a la tabla autores res =
		 * lanzarSelect(sqlSelect+"Autores;");
		 * 
		 * int nuevoId0=getNuevoID("libros", "codigoAutor");
		 * System.out.println("El nuevo ID del autor es "+nuevoId0); String
		 * actualizaGrabaFila0 = "INSERT INTO autores VALUES ("+nuevoId0+
		 * ",'Rommel Ayala','Barcelona','19000412')";
		 * 
		 * int filasAfectadas0=grabarFila(actualizaGrabaFila0);
		 * System.out.println
		 * (filasAfectadas0+" Fila(s) afectadas insertando nuevo autor"); -fin
		 * de 5
		 */

		/**
		 * 6 Añadir el código necesario en el main para crear una instrucción
		 * que modifique la fecha del libro cuyo código es el 3 por la fecha
		 * actual. Utilizad el método grabarFila(). res =
		 * lanzarSelect(sqlSelect+"libros;"); String actualizaGrabaFila1=
		 * "UPDATE libros SET FECHA='1800-03-01' WHERE codigoLibro=3";
		 * 
		 * int filasAfectadas1=grabarFila(actualizaGrabaFila1);
		 * System.out.println
		 * (filasAfectadas1+" Fila(s) afectadas actualizando fecha de libro");
		 * -fin de 6
		 */
	}
}
