package Catalogo;

import Propiedades.*;
import Comic.*;
import Estructuras.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
            for(;iteraciones > 0;--iteraciones){
                
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
        
            //Lectura tomo
            array = new DynamicArray<Tomo>();            
            
            try {
            flujo_entrada = new Scanner(new File("tomo.txt"));
            String primera_linea = flujo_entrada.nextLine();
            Scanner temp_scanner = new Scanner(primera_linea);
            temp_scanner.next();
            iteraciones = flujo_entrada.nextInt();     
        } catch (FileNotFoundException ex){System.out.println("Error en la lectura de tomos");}
            
            for(;iteraciones > 0;--iteraciones){
                String nombre = flujo_entrada.next();
                int agno_publicacion = flujo_entrada.nextInt();
                String s_escritor = flujo_entrada.next();
                String s_dibujante = flujo_entrada.next();
                boolean finalizado = flujo_entrada.nextBoolean();
                
                int n_categorias = flujo_entrada.nextInt();
                DynamicArray<Categoria> tomo_categorias = new DynamicArray<Categoria>();
                for(int i = 0; i < n_categorias; ++i){
                   Categoria categoria = new Categoria(flujo_entrada.next());
                   tomo_categorias.pushBackCheck(categoria); 
                }
                
                Autor escritor = null;
                
                Autor dibujante = null;
                
                for(int i = 0; i < catalogo.getAutores().getSize(); ++i){
                    String t_autor = catalogo.getAutores().get(i).getNombre();
                    if(t_autor.equalsIgnoreCase(s_escritor)){
                        s_escritor = null;
                        
                        escritor = catalogo.getAutores().get(i);
                    }
                    
                    if(t_autor.equalsIgnoreCase(s_dibujante)){
                        s_dibujante = null;
                        
                        dibujante = catalogo.getAutores().get(i);
                    }
                    
                    if(s_escritor == null && s_dibujante == null) break;
                    
                }
                if(s_escritor != null){
                    escritor = new Autor(s_escritor);
                }
             
                if(s_dibujante != null){
                    dibujante = new Autor(s_dibujante);
                    
                }
                
                //Lectura comic dentro de tomo
                int n_comics = flujo_entrada.nextInt();
                Tomo tomo = new Tomo(nombre, escritor, dibujante, agno_publicacion, finalizado, tomo_categorias);
                
                for(int i = 0; i < n_comics; ++i){
                    String nombre_c = flujo_entrada.next();
                    int agno_publicacion_c = flujo_entrada.nextInt();
                    String s_escritor_c = flujo_entrada.next();
                    String s_dibujante_c = flujo_entrada.next();
                    
                    Autor escritor_c = null;
                
                    Autor dibujante_c = null;
                
                    for(int j = 0; j < catalogo.getAutores().getSize(); ++j){
                    String t_autor_c = catalogo.getAutores().get(j).getNombre();
                    if(t_autor_c.equalsIgnoreCase(s_escritor_c)){
                        s_escritor_c = null;
                        
                        escritor_c = catalogo.getAutores().get(j);
                    }
                    
                    if(t_autor_c.equalsIgnoreCase(s_dibujante_c)){
                        s_dibujante_c = null;
                        
                        dibujante_c = catalogo.getAutores().get(j);
                    }
                    
                    if(s_escritor_c == null && s_dibujante_c == null) break;
                    
                    }
                    if(s_escritor_c != null){
                        escritor_c = new Autor(s_escritor_c);
                    }
             
                    if(s_dibujante_c != null){
                        dibujante_c = new Autor(s_dibujante_c);
                    }
                    
                    Comic comic = new Comic(nombre_c, agno_publicacion_c, escritor_c, dibujante_c);
                    tomo.agregarAtras(comic);
                    
                }
                array.pushBack(tomo);
            }
            catalogo.setTomos(array);            

            //Lectura editorial, los tomos ya deben haber sido creados antes de añadirlos a un editorial
            array = new DynamicArray<Editorial>();
            try {
                flujo_entrada = new Scanner(new File("editorial.txt"));
                String primera_linea = flujo_entrada.nextLine();
                Scanner temp_scanner = new Scanner(primera_linea);
                temp_scanner.next();
                iteraciones = flujo_entrada.nextInt();     
            } catch (FileNotFoundException ex){System.out.println("Error en la lectura de editoriales");}
            
             for(;iteraciones > 0;--iteraciones){
                 String nombre = flujo_entrada.next();
                 
                 DynamicArray<Tomo> tomos = new DynamicArray<Tomo>();
                 
                 Editorial editorial = new Editorial(nombre,tomos);
                 
                 int n_tomos = flujo_entrada.nextInt();
                 
                 for(int i = 0; i < n_tomos; ++i){
                     String nombre_t = flujo_entrada.next();
                     
                     int agno_publicacion_t = flujo_entrada.nextInt();
                     
                     Tomo tomo = null;
                     
                     for(int j = 0; j < catalogo.getTomos().getSize(); ++j){
                         Tomo temp = catalogo.getTomos().get(j);
                         if(temp.getNombre().equalsIgnoreCase(nombre_t) && temp.getAgno_publicacion() == agno_publicacion_t){
                             tomo = temp;
                             break;
                         }
                     }
                     
                tomos.pushBack(tomo);
                tomo.setEditorial(editorial);
                array.pushBack(editorial);
                editorial.setTomos(tomos);
                 }
                 
             }
             catalogo.setEditoriales(array);
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
