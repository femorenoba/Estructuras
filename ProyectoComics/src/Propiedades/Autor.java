package Propiedades;

public class Autor {

	private String nombre ;
	private int edad;
	private Categoria[] categorias;
	
	public Autor(String nombre, int edad, Categoria[] categorias) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.categorias = categorias;
	}

	protected String getNombre() {
		return nombre;
	}



	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}



	protected int getEdad() {
		return edad;
	}



	protected void setEdad(int edad) {
		this.edad = edad;
	}



	protected Categoria[] getCategorias() {
		return categorias;
	}


	protected void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}

	

}
