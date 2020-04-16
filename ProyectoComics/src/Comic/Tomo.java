package Comic;

import java.util.*;

import Propiedades.*; 

public class Tomo {
	
	private String nombre;
	private Autor autor;
	private int ano_publicacion;
	private String descripcion;
	private Comic cabeza;
	private Comic cola;
	private int tamano;
	private boolean finalizado;
	private Categoria[] categorias;
	private String lenguaje;
	
	
	
	//Contructor clase Tomo

	public Tomo(String nombre, Autor autor, int ano_publicacion, String descripcion, 
			boolean finalizado, Categoria[] categorias, String lenguaje) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.ano_publicacion = ano_publicacion;
		this.descripcion = descripcion;
		this.cabeza = null;
		this.cola = null;
		this.finalizado = finalizado;
		this.categorias = categorias;
		this.lenguaje = lenguaje;
		this.tamano = 0;
	}        

	  public boolean vacio()
	    {
	        return(tamano==0);
	    }
	    
	    public int tamano()
	    {
	        return(tamano);
	    }
	    
	    public void agregarFrente(Comic comic)
	    {
	        comic.setSecuela(cabeza);
	        comic.setPrecuela(cabeza.getPrecuela());
	        this.cabeza.setPrecuela(comic);
	        this.cabeza = comic;
	        if(cola==null){
	            this.cola = cabeza;
	        }
	        this.tamano++;
	    }
	    
	    public Comic quitarFrente()
	    {
	        if(tamano==0){
	            throw new EmptyStackException();
	        }
	        Comic viejaCabeza = this.cabeza;
	        this.cabeza = cabeza.getSecuela();
	        if(cabeza!=null) {
	        	this.cabeza.getSecuela().setPrecuela(cabeza);
	        }
	        if(cabeza==null){
	            this.cola = null;
	        }
	        this.tamano--;
	        return viejaCabeza;
	    }
	    
	    public void agregarAtras(Comic comic)
	    {
	        comic.setSecuela(null);
	        if(cola==null){
	            this.cabeza = comic;
	            this.cola = comic;
	            comic.setPrecuela(null);
	        } else{
	            this.cola.setSecuela(comic);
	            comic.setPrecuela(cola);
	            this.cola = comic;
	        }
	        this.tamano++;
	    }
	    
	    public Comic quitarAtras()
	    {
	        if(tamano==0){
	            throw new EmptyStackException();
	        }
	        Comic viejaCola = this.cola;
	        if(cabeza==cola){
	            this.cabeza = null;
	            this.cola = null;
	        } else{
	        	this.cola = cola.getPrecuela();
	        	this.cola.setSecuela(null);
	        }
	        this.tamano--;
	        return viejaCola;
	    }
	    
	    public void agregarDespues(Comic comicSiendoAgregado, Comic comic){
	    	comicSiendoAgregado.setSecuela(comic.getSecuela());
	    	comicSiendoAgregado.setPrecuela(comic);
	        comic.setSecuela(comicSiendoAgregado);
	        if(comicSiendoAgregado.getPrecuela()!=null){
	            comicSiendoAgregado.getSecuela().setSecuela(comicSiendoAgregado);
	        }
	        if(cola==comic){
	            this.cola = comicSiendoAgregado;
	        }
	        this.tamano++;
	    }
	    public void agregarAntes(Comic comicSiendoAgregado, Comic comic){
	    	comicSiendoAgregado.setSecuela(comic);
	    	comicSiendoAgregado.setPrecuela(comic.getPrecuela());
	        if(comicSiendoAgregado.getPrecuela()!=null) {
	        	comicSiendoAgregado.getPrecuela().setSecuela(comicSiendoAgregado);
	        }
	    	if(cabeza==comic){
	            this.cabeza = comicSiendoAgregado;
	        } 
	        this.tamano++;
	    }
	    public Comic picoFrente(){
	        if(tamano==0){
	            throw new EmptyStackException();
	        }
	        return(this.cabeza);
	    }
	    public Comic picoAtras(){
	        if(tamano==0){
	            throw new EmptyStackException();
	        }
	        return(this.cola);
	    }
	
	
	protected String getNombre() {
		return nombre;
	}



	protected Autor getAutor() {
		return autor;
	}


	protected void setAutor(Autor autor) {
		this.autor = autor;
	}


	protected Categoria[] getCategorias() {
		return categorias;
	}


	protected void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}


	protected String getLenguaje() {
		return lenguaje;
	}


	protected void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
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




	protected Comic getCabeza() {
		return cabeza;
	}




	protected void setCabeza(Comic cabeza) {
		this.cabeza = cabeza;
	}




	protected Comic getCola() {
		return cola;
	}




	protected void setCola(Comic cola) {
		this.cola = cola;
	}




	protected boolean isFinalizado() {
		return finalizado;
	}




	protected void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	
	
}
