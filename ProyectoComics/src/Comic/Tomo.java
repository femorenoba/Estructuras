package Comic;
public class Tomo {
	
	private String nombre;
	private int ano_publicacion;
	private String descripcion;
	private Comic cabeza;
	private Comic cola;
	private boolean finalizado;
	
	
	
	
	//Contructor clase Tomo
	public Tomo(String nombre, int ano_publicacion, String descripcion) {
		super();
		this.nombre = nombre;
		this.ano_publicacion = ano_publicacion;
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
}
