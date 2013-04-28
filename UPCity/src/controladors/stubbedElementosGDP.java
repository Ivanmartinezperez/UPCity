/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import java.util.TreeMap;
import elementos.Elemento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ArclorenSarth
 */
public class stubbedElementosGDP {
    
    private static stubbedElementosGDP INSTANCE = null;
   
    
    private stubbedElementosGDP(){
        
    }
    
    private static void creaInstancia() {
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
    public void leerElementos(TreeMap<String,Elemento> TE0,
                              HashMap<Integer,ArrayList<Elemento>> HE0,
                              TreeMap<String,Elemento> TE1,
                              HashMap<Integer,ArrayList<Elemento>> HE1,
                              TreeMap<String,Elemento> TE2,
                              HashMap<Integer,ArrayList<Elemento>> HE2,
                              TreeMap<String,Elemento> TE3,
                              HashMap<Integer,ArrayList<Elemento>> HE3){
        
        System.out.println("Simulando lectura de disco...Cargando Elementos\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment.\n For now you have to keep up with temporal "
                + "data"); 
        
        
    }
        
    
    public void escribirElemento(Elemento e){
        System.out.println("Simulando escritura en disco...Guardando Elemento\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment");
    }
        
    
    
    public boolean existeElemEnBarrios(String Elem){
        System.out.println("Simulando lectura de disco...Buscando Elemento\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment");
        return false;
    }
    
    
    public void eliminarElemDisco(String Elem){
        System.out.println("Simulando escritura en disco...Eliminando Elemento\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment");
    }
    
}
