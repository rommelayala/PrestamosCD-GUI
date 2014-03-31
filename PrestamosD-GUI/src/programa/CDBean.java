package programa;
public class CDBean implements Comparable<Object> {

	int id;
	String titulo, autor, genero, prestamo;

	public CDBean( int id,String titulo, String autor, String genero) {
		super();
		this.id=id;/*1 añado id*/
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
	}
	/*2 añado id */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/*fmod*/
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(String prestamo) {
		this.prestamo = prestamo;
	}

	public String toString() {
		return titulo;
	}

	/* Dos titulos son iguales aunque difieran en 
	 * mayusculas o minusculas */
	@Override
	public int compareTo(Object arg0) {		
		String otroTitulo=((CDBean)arg0).getTitulo();		
		return titulo.compareToIgnoreCase(otroTitulo);		 
	}

}
