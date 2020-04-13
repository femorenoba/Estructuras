package Propiedades;

public class Autor {
	private String nombre ;
	private int edad;
	
	
	
	
	// Getters and Setters de la clase autor
	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public int getEdad() {
		return edad;
	}





	public void setEdad(int edad) {
		this.edad = edad;
	}



   //Constructor de la clase autor
	
	public Autor(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	

}
