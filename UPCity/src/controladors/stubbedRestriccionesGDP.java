/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import restricciones.Restriccion;
import java.util.TreeMap;

/**
 *
 * @author ArclorenSarth
 */
public class stubbedRestriccionesGDP {
    
    private static stubbedRestriccionesGDP INSTANCE = null;
   
    private stubbedRestriccionesGDP(){
        
    }
    
    private synchronized static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new stubbedRestriccionesGDP();
        }
    }

    public static stubbedRestriccionesGDP getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }
    
    
    
    
    
    /**
     * Lectura de datos persistentes del disco, lee todas las instancias de 
     * restriccion del disco y las pasa al TreeMap TablaRest que le llega como 
     * parametro.
     * @param TablaRest 
     */
    public void leerRestricciones(TreeMap<String,Restriccion> TablaRest){
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S
    }
    
}
