package Propiedades;

public class Usuario {
	
	private Stack busquedasRecientes;
	private String nombre;
	private String contraseña;
	
	public Usuario(Stack busquedasRecientes, String nombre, String contraseña) {
		super();
		this.busquedasRecientes = busquedasRecientes;
		this.nombre = nombre;
		this.contraseña = contraseña;
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

	protected String getContraseña() {
		return contraseña;
	}

	protected void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
