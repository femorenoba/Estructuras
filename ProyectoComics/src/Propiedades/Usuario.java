package Propiedades;

public class Usuario {
	
	private Stack busquedasRecientes;
	private String nombre;
	private String contrase�a;
	
	public Usuario(Stack busquedasRecientes, String nombre, String contrase�a) {
		super();
		this.busquedasRecientes = busquedasRecientes;
		this.nombre = nombre;
		this.contrase�a = contrase�a;
	}

	protected Stack getBusquedasRecientes() {
		return busquedasRecientes;
	}

	protected void setBusquedasRecientes(Stack busquedasRecientes) {
		this.busquedasRecientes = busquedasRecientes;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getContrase�a() {
		return contrase�a;
	}

	protected void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
}
