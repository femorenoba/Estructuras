package my.packages;

import my.packages.Catalogo.Catalogo;
import my.packages.Comic.Comic;
import my.packages.Comic.Tomo;


public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        catalogo.leerDatos();       
        
        Tomo tomo = catalogo.getTomos().get(0);
        
        System.out.println(tomo.tamano());
        
        Comic comic = catalogo.tomoQuitarFrente(tomo);
        catalogo.tomoAgregarDespues(comic, tomo.getCabeza(), tomo);
        
        
        
        }
}
