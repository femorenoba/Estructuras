package Propiedades;

import Comic.Tomo;

public class Editorial {
	
	private String nombre;
	private Tomo[] tomos;



//Getters and Setter de la clase Editorial.

	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

	//Contructor clase Editorial.


	protected Tomo[] getTomos() {
		return tomos;
	}





	protected void setTomos(Tomo[] tomos) {
		this.tomos = tomos;
	}





	public Editorial(String nombre, Tomo[] tomos) {
		super();
		this.nombre = nombre;
		this.tomos = tomos;
	}


}
