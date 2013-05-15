/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import barrio.Barrio;
import java.util.TreeMap;
import elementos.Cjt_Elementos;
import mapa.Plano;
import restricciones.Restriccion;

/**
 *
 * @author ArclorenSarth
 */
public class stubbedBarriosGDP {
    
    private static stubbedBarriosGDP INSTANCE = null;
    CtrlPersDisco PERSDisco;
    
    private stubbedBarriosGDP(){
        PERSDisco = CtrlPersDisco.getInstance();
    }
    
    private static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new stubbedBarriosGDP();
        }
    }

    public static stubbedBarriosGDP getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }
    
    /////LECTURAS DEL DISCO/////
    
    /**
     * Funcion que lee los nombres de los barrios ya creados y los guarda en el
     * TreeMap TablaBarrio.
     * @param TablaBarrios TreeMap que utilizamos para pasar los nombres de los
     * barrios al controlador de dominio del barrio.
     */
    public void leerBarriosCreados(TreeMap<String,Integer> TablaBarrios){
        System.out.println("Simulando lectura de disco...Cargando Barrios\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment.\n For now you have to keep up with temporal "
                + "data\n");
    }
    
    
    /**
     * Lectura de datos persistentes del disco, lee los datos del barrio con el
     * nombre nomBarr, que le llega como parametro, guardado en el disco.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura de los 
     * datos del barrio.
     * @param Bar El Barrio donde se guardan los datos leidos para pasarlos al
     * controlador de barrios
     */     
    public void leerBarrio(String nomBarr, Barrio Bar){
    System.out.println("Simulando lectura de disco...Cargando Barrio\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment.\n For now you have to keep up with temporal "
                + "data\n");    
    }
    
    
    /**
     * Lectura de datos persistentes del disco, lee el Conjunto de Elementos 
     * guardado en el disco que le corresponde al barrio con el nombre nomBarr, 
     * que le llega como parametro, y lo guarda en el Cjt_Elementos CjtElem que 
     * le llega como parametro.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura del 
     * Conjunto de elementos.
     * @param CjtElem El Cjt_Elementos en el cual se guardaran los elementos 
     * leidos del disco para pasarlos al controlador de barrios.
     */     
    public void leerCjtElem(String nomBarr, Cjt_Elementos CjtElem){
        System.out.println("Simulando lectura de disco...Cargando CjtElementos\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment.\n For now you have to keep up with temporal "
                + "data\n");
    }
    
    
    /**
     * Lectura de datos persistentes del disco, lee el Conjunto de Restricciones
     * guardado en el disco que le corresponde al barrio con el nombre nomBarr, 
     * que le llega como parametro, y las pasa al TreeMap CjtRest que le llega
     * como parametro.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura del 
     * Conjunto de Restricciones.
     * @param CjtRest El TreeMap de Restricciones en el cual se guardaran las 
     * restricciones leidas del disco para pasarlos al controlador de barrios.  
     */
    public TreeMap<String,Restriccion> leerCjtRest(String nomBarr){
        return (TreeMap<String,Restriccion>) 
                PERSDisco.llegeixBinari(nomBarr + "/" , nomBarr + "-CjtRest");
    }
    
    
    /**
     * Lectura de datos persistentes del disco, lee el Plano guardado en el 
     * disco que le corresponde al barrio con el nombre nomBarr, que le llega 
     * como parametro, y lo pasa al Plano Mapa que le llega como parametro.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura del 
     * Plano.
     * @param Mapa El Plano en el cual se guardara el mapa del barrio leido del
     * disco para pasarlo al controlador de barrios.  
     */
    public void leerMapa(String nomBarr, Plano Mapa){
        System.out.println("Simulando lectura de disco...Cargando Plano\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment.\n For now you have to keep up with temporal "
                + "data\n");
    }
    
    
    
    /////ESCRITURAS AL DISCO/////   
    
    /**
     * escritura de datos persistentes del disco, escribe al disco los datos del
     * barrio con el nombre nomBarr, que le llega como parametro.
     * @param nomBarr Nombre del Barrio del cual se escriben los datos.
     * @param Bar El Barrio que se quiere escribir al disco.
     */     
    public void escribirBarrio(String nomBarr, Barrio Bar){
        System.out.println("Simulando escritura en disco...Guardando Barrio\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment.\n");
    }
    
    
    /**
     * Escritura de datos persistentes al disco, escribe el Conjunto de Elementos
     * CjtElem que le llega como parametro, guardandolo en el disco como el que 
     * le corresponde al barrio con el nombre nomBarr, que le llega como 
     * parametro.
     * @param nomBarr Nombre del Barrio al que le corresponde Conjunto de 
     * elementos que se va guardar.
     * @param CjtElem El Cjt_Elementos que se quiere guardar en el disco.
     */     
    public void escribirCjtElem(String nomBarr, Cjt_Elementos CjtElem){
        System.out.println("Simulando escritura en disco...Guardando CjtElementos\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment.\n");
    }
    
    
    /**
     * Escritura de datos persistentes al disco, escribe el Conjunto de 
     * Restricciones CjtRest que le llega como parametro, guardandolo en el 
     * disco como el que le corresponde al barrio con el nombre nomBarr, que le 
     * llega como parametro.
     * @param nomBarr Nombre del Barrio al que le corresponde Conjunto de 
     * Restricciones que se va guardar.
     * @param CjtRest El TreeMap de restricciones que se quiere guardar en el 
     * disco.
     */
    public void escribirCjtRest(String nomBarr, TreeMap<String,Restriccion> CjtRest){
        PERSDisco.escriuBinari(nomBarr + "/" , nomBarr + "-CjtRest",CjtRest);
    }
    
    /**
     * Escritura de datos persistentes al disco, escribe el Plano Mapa que le 
     * llega como parametro, guardandolo en el disco como el que le corresponde 
     * al barrio con el nombre nomBarr, que le llega como parametro.
     * @param nomBarr Nombre del Barrio al que le corresponde el Plano que se va
     * guardar.
     * @param Mapa El Plano que se quiere guardar en el disco.
     */
    public void escribirMapa(String nomBarr, Plano Mapa){
        System.out.println("Simulando escritura en disco...Guardando Plano\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment.\n");
    }
    
    
     
    
}
