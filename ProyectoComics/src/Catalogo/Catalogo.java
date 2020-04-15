package Catalogo;

import Propiedades.*;
import Comic.*;

public class Catalogo {
	
	private Editorial[] editoriales;
	private Tomo[] tomos;
	private Autor[] autores;
	private Categoria[] categorias;
	private Usuario[] usuarios;
	
	public Catalogo(Editorial[] editoriales, Tomo[] tomos, Autor[] autores, Categoria[] categorias,
			Usuario[] usuarios) {
		super();
		this.editoriales = editoriales;
		this.tomos = tomos;
		this.autores = autores;
		this.categorias = categorias;
		this.usuarios = usuarios;
	}

	public Comic[] buscarPorAno(int ano){
		return null;
		
	}

	public Comic[] buscarPorAutor(Autor autor){
		return null;
		
	}

	public Comic[] buscarPorNombre(String nombre){
		return null;
		
	}

	public Comic[] buscarPorTipo(Categoria categoria){
		return null;
		
	}

	public void actualizarComic(Comic comic, int tipoOperacion, String nuevaInformacion){
		
	}
	
	protected Editorial[] getEditoriales() {
		return editoriales;
	}

	protected void setEditoriales(Editorial[] editoriales) {
		this.editoriales = editoriales;
	}

	protected Tomo[] getTomos() {
		return tomos;
	}

	protected void setTomos(Tomo[] tomos) {
		this.tomos = tomos;
	}

	protected Autor[] getAutores() {
		return autores;
	}

	protected void setAutores(Autor[] autores) {
		this.autores = autores;
	}

	protected Categoria[] getCategorias() {
		return categorias;
	}

	protected void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}

	protected Usuario[] getUsuarios() {
		return usuarios;
	}

	protected void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	
}
