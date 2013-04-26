/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import restricciones.Restriccion;
import java.util.TreeMap;
import restricciones.Restriccion_ubicacion;

/**
 *
 * @author ArclorenSarth
 */
public class stubbedRestriccionesGDP {
    
    private static stubbedRestriccionesGDP INSTANCE = null;
   
    
    private stubbedRestriccionesGDP(){
        
    }
    
    private static void creaInstancia() {
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
    public void leerRestricciones(TreeMap<String,Restriccion_ubicacion> TablaRest){
        
         System.out.println("Simulando lectura de disco...Cargando Restricciones");
    }
    
    public void escribirRestriccion(Restriccion r){
        
    }
    
}
