package my.packages.Propiedades;

import my.packages.Estructuras.Stack;

public class Usuario {
	
	private Stack<String> busquedasRecientes;
	private String nombre;
	private String password;
	
	public Usuario(String nombre, String password) {
		super();
		this.busquedasRecientes = null;
		this.nombre = nombre;
		this.password = password;
	}

	protected Stack<String> getBusquedasRecientes() {
		return busquedasRecientes;
	}

	protected void setBusquedasRecientes(Stack<String> busquedasRecientes) {
		this.busquedasRecientes = busquedasRecientes;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}
	
	
}
