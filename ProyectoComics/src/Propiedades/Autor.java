package Propiedades;

import Estructuras.*;

public class Autor {

	private String nombre ;
	private int edad;
	private DynamicArray<Categoria> categorias;
	
	public Autor(String nombre, int edad, DynamicArray<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.categorias = categorias;
	}

        public Autor(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        } 
        
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

        public DynamicArray<Categoria> getCategorias() {
        return categorias;
        }

        public void setCategorias(DynamicArray<Categoria> categorias) {
        this.categorias = categorias;
        }

    @Override
    public boolean equals(Object obj) {
        return this.nombre.equalsIgnoreCase(((Autor)obj).getNombre()) &&
                this.edad == ((Autor)obj).getEdad();
    }
        
        


	

	

}
