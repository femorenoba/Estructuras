package Comic;

import Propiedades.*;

public class Comic {


	private String nombre;
	private int ano_publicacion;
	private String descripcion;
	private Comic secuela;
	private Comic precuela;
        private Autor escritor; //Los puse como string porque no es posible para comic acceder al arreglo con todos los autores.
        private Autor dibujante;
	
	
	
	//Contructor de la clase Comic. 
	public Comic(String nombre, int ano_publicacion, String descripcion, Autor escritor, Autor dibujante) {
		super();
		this.nombre = nombre;
		this.ano_publicacion = ano_publicacion;
		this.descripcion = descripcion;
                this.escritor = escritor;
                this.dibujante = dibujante;
	}

	protected String getNombre() {
		return nombre;
	}



	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}



	protected int getAno_publicacion() {
		return ano_publicacion;
	}



	protected void setAno_publicacion(int ano_publicacion) {
		this.ano_publicacion = ano_publicacion;
	}



	protected String getDescripcion() {
		return descripcion;
	}



	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	protected Comic getSecuela() {
		return secuela;
	}



	protected void setSecuela(Comic secuela) {
		this.secuela = secuela;
	}



	protected Comic getPrecuela() {
		return precuela;
	}



	protected void setPrecuela(Comic precuela) {
		this.precuela = precuela;
	}



}