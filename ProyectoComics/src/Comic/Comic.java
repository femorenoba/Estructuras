package Comic;

import Propiedades.*;

public class Comic {


	private String nombre;
	private int agno_publicacion;
	private String descripcion;
	private Comic secuela;
	private Comic precuela;
        private Autor escritor; 
        private Autor dibujante;
	
	
	
	//Contructor de la clase Comic. 
	
	public Comic(String nombre, int agno_publicacion, Autor escritor, Autor dibujante, String descripcion) {
        this.nombre = nombre;
        this.agno_publicacion = agno_publicacion;
        this.descripcion = descripcion;
        this.escritor = escritor;
        this.dibujante = dibujante;
	}

    public Comic(String nombre, int agno_publicacion, Autor escritor, Autor dibujante) {
        this.nombre = nombre;
        this.agno_publicacion = agno_publicacion;
        this.escritor = escritor;
        this.dibujante = dibujante;
    }
             
    protected String getNombre() {
        return nombre;
    }


	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}



	protected int getAgno_publicacion() {
		return agno_publicacion;
	}

        public Autor getEscritor() {
            return escritor;
        }

        public void setEscritor(Autor escritor) {
            this.escritor = escritor;
        }

        public Autor getDibujante() {
            return dibujante;
        }

        public void setDibujante(Autor dibujante) {
            this.dibujante = dibujante;
        }

        

	protected void setAgno_publicacion(int agno_publicacion) {
		this.agno_publicacion = agno_publicacion;
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

    @Override
    public boolean equals(Object obj) {
        Comic comic = (Comic)obj;
        return this.agno_publicacion == comic.getAgno_publicacion() &&
                this.dibujante.equals(comic.getDibujante())         &&
                this.escritor.equals(comic.getEscritor())           &&
                this.nombre.equalsIgnoreCase(comic.getNombre());
    }     

}