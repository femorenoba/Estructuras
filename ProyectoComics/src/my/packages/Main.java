package my.packages;

import java.util.Iterator;
import my.packages.Catalogo.Catalogo;
import my.packages.Comic.Comic;
import my.packages.Comic.Tomo;
import my.packages.Estructuras.DynamicArray;


public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        catalogo.leerDatos(); 
        
        /**/DynamicArray<Tomo> res = catalogo.buscarPorAutor("dave");
        System.out.println(res.getSize());
        for(int i = 0; i < res.getSize(); ++i)
        {
        	System.out.println(res.get(i).getNombre());
        }
        
        
        
    }
}
