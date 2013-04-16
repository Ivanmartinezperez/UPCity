/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import java.util.TreeMap;
import elementos.Elemento;

/**
 *
 * @author ArclorenSarth
 */
public class stubbedElementosGDP {
    
    private static stubbedElementosGDP INSTANCE = null;
   
    private stubbedElementosGDP(){
        
    }
    
    private synchronized static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new stubbedElementosGDP();
        }
    }

    public static stubbedElementosGDP getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }
    
    
    
    
    /**
     * Lectura de datos persistentes del disco, lee todas las instancias de 
     * elemento del disco y las pasa al TreeMap TablaElem que le llega como 
     * parametro.
     * @param TablaElem 
     */     
    public void leerElementos(TreeMap<String,Elemento> TablaElem){
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S    
    }
    
    public void escribirElemento(){
        
    }
    
    
    
    
}
