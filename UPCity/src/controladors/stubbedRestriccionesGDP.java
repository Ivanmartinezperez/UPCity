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
        System.out.println("Simulando lectura de disco...Cargando "
                + "Restricciones\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment\n For now you have to keep up with temporal "
                + "data\n");
    }
    
    public void escribirRestriccion(Restriccion r){
        System.out.println("Simulando escritura en disco...Guardando "
                + "Restriccion\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment\n");
    }
    
    public boolean existeRestEnBarrios(String id){
        System.out.println("Simulando escritura en disco...Buscando "
                + "Restriccion en barrios\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment\n");
        return false;
    }
    
    public void eliminarElemDisco(String id){
        System.out.println("Simulando escritura en disco...Eliminando "
                + "Restriccion\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment\n");
    }
    
}
