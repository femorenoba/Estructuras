package Comic;

public class Comic {
	
	private String nombre;
	private int ano_publicacion;
	private String descripcion;
	private Comic secuela;
	private Comic precuela;
	
	
	
	//Contructor de la clase Comic. 
	public Comic(String nombre, int ano_publicacion, String descripcion) {
		super();
		this.nombre = nombre;
		this.ano_publicacion = ano_publicacion;
		this.descripcion = descripcion;
	}

	
}
