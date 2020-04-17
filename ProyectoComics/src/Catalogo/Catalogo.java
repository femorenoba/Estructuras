package Catalogo;

import Propiedades.*;
import Comic.*;
import Estructuras.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Catalogo {
    
        public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        }

	private DynamicArray<Editorial> editoriales;
	private DynamicArray<Tomo> tomos;
	private DynamicArray<Autor> autores;
	private DynamicArray<Categoria> categorias;
	private DynamicArray<Usuario> usuarios;

    public Catalogo(DynamicArray<Editorial> editoriales, DynamicArray<Tomo> tomos, DynamicArray<Autor> autores, DynamicArray<Categoria> categorias, DynamicArray<Usuario> usuarios) {
        this.editoriales = editoriales;
        this.tomos = tomos;
        this.autores = autores;
        this.categorias = categorias;
        this.usuarios = usuarios;
    }
	
        
        public Catalogo()
        {
            this(null,null,null,null,null);
        }       

	public Comic[] buscarPorAgno(int agno){
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

    public DynamicArray<Editorial> getEditoriales() {
        return editoriales;
    }
    public void setEditoriales(DynamicArray<Editorial> editoriales) {
        this.editoriales = editoriales;
    }
    
    public DynamicArray<Tomo> getTomos() {
        return tomos;
    }
    public void setTomos(DynamicArray<Tomo> tomos) {
        this.tomos = tomos;
    }
    
    public DynamicArray<Autor> getAutores() {
        return autores;
    }
    public void setAutores(DynamicArray<Autor> autores) {
        this.autores = autores;
    }
    
    public DynamicArray<Categoria> getCategorias() {
        return categorias;
    }
    public void setCategorias(DynamicArray<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public DynamicArray<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(DynamicArray<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
	
        //Persistencia
        protected void leerDatos(Catalogo catalogo)
        {
            Scanner flujo_entrada = null;
            int iteraciones = 0;
            DynamicArray array = null;
            //Lectura catalógo 
            try {
            flujo_entrada = new Scanner(new File("catalogo.txt"));
            String primera_linea = flujo_entrada.nextLine();
            Scanner temp_scanner = new Scanner(primera_linea);
            temp_scanner.next();
            iteraciones = flujo_entrada.nextInt();
        } catch (FileNotFoundException ex){System.out.println("Error en la lectura de catalógo");}
            
            array = new DynamicArray<Categoria>();
            
            for(;iteraciones > 0;--iteraciones)
            {
                Categoria categoria = new Categoria(flujo_entrada.nextLine());
                array.pushBackCheck(categoria);
            }
            catalogo.setCategorias(array);
            
            //Lectura autor
            try {
            flujo_entrada = new Scanner(new File("autor.txt"));
            String primera_linea = flujo_entrada.nextLine();
            Scanner temp_scanner = new Scanner(primera_linea);
            temp_scanner.next();
            iteraciones = flujo_entrada.nextInt();
        } catch (FileNotFoundException ex){System.out.println("Error en la lectura de catalógo");}
            array = new DynamicArray<Autor>();
            
            for(;iteraciones > 0;--iteraciones)
            {
                String nombre = flujo_entrada.next();
                int edad = flujo_entrada.nextInt();
                Autor autor = new Autor(nombre,edad);
                boolean existe_autor = false;
                if(array.pushBackCheck(autor)) //Si ya existe un autor, entonces basta con buscar ese autor y comparar categorias
                {
                    autor = buscarAutor(nombre, edad);
                    existe_autor = true;
                }
                
                int numero_categorias = flujo_entrada.nextInt();
                for(int i = 0; i < numero_categorias; ++i)
                {
                    Categoria categoria = new Categoria(flujo_entrada.next());
                    autor.getCategorias().pushBackCheck(categoria);
                }
                
                if(!existe_autor) catalogo.autores.pushBack(autor);              
            }
            catalogo.setAutores(array);
            
            //Lectura comic
            //Lectura tomo
            //Lectura editorial
            //Lectura lenguaje
        }       
        protected Autor buscarAutor(String nombre, int edad)
        {
            Autor res = new Autor(nombre,edad);
            
            for(int i = 0; i < this.getAutores().getSize(); ++i)
            {
                if(res.equals(this.getAutores().get(i)))
                {
                    return this.getAutores().get(i);
                }
            }
            return null;
        }
}
