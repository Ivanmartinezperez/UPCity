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
   
    
    private stubbedBarriosGDP(){
        
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
     * Lectura de datos persistentes del disco, lee los datos del barrio con el
     * nombre nomBarr, que le llega como parametro, guardado en el disco.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura de los 
     * datos del barrio.
     * @param Bar El Barrio donde se guardan los datos leidos para pasarlos al
     * controlador de barrios
     */     
    public void leerBarrio(String nomBarr, Barrio Bar){
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S    
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
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S    
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
    public void leerCjtRest(String nomBarr, TreeMap<String,Restriccion> CjtRest){
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S
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
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S
    }
    
    
    
    /////ESCRITURAS AL DISCO/////   
    
    /**
     * escritura de datos persistentes del disco, escribe al disco los datos del
     * barrio con el nombre nomBarr, que le llega como parametro.
     * @param nomBarr Nombre del Barrio del cual se escriben los datos.
     * @param Bar El Barrio que se quiere escribir al disco.
     */     
    public void escribirBarrio(String nomBarr, Barrio Bar){
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S    
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
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S    
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
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S
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
//        Aqui simulamos los datos persistentes itroduciendolos por consola, lo 
//        cual tengo la duda que este del todo correcto :S
    }
    
    
     
    
}
