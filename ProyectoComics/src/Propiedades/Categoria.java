package Propiedades;

public class Categoria {
	
	private String nombre;

	
	//Getters and Setters de la clase Categoria
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


    //Contructor de la clase categoria
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
    
}
