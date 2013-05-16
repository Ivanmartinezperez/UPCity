/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import barrio.Barrio;
import java.util.TreeMap;
import elementos.Cjt_Edificios;
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
     * @return TreeMap con los nombres de los Barrios guardados en disco.
     */
    public TreeMap<String,Integer> leerBarriosCreados(){
        String[] lis = PERSDisco.listarDirectorio("./Data/Barrios/");
        TreeMap<String,Integer> TabBar = new TreeMap();
        for(int i=0; i<lis.length; ++i){
            if(!lis[i].endsWith(".o")){
                TabBar.put(lis[i],(Integer)1);
            }
        }
        return TabBar;
    }
    
    
    /**
     * Lectura de datos persistentes del disco, lee los datos del barrio con el
     * nombre nomBarr, que le llega como parametro, guardado en el disco.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura de los 
     * datos del barrio.
     * @return El Barrio con los datos leidos del disco.
     */     
    public Barrio leerBarrio(String nomBarr){
        return (Barrio) 
                PERSDisco.leerObjeto(nomBarr + "/" , nomBarr + "-Barrio");
    }
    
    
    /**
     * Lectura de datos persistentes del disco, lee el Conjunto de Elementos 
     * guardado en el disco que le corresponde al barrio con el nombre nomBarr, 
     * que le llega como parametro, y lo guarda en el Cjt_Elementos CjtElem que 
     * le llega como parametro.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura del 
     * Conjunto de elementos.
     * @return El Cjt_Edificios con los elementos leidos del disco.
     */     
    public Cjt_Edificios leerCjtElem(String nomBarr){
        return (Cjt_Edificios) 
                PERSDisco.leerObjeto(nomBarr + "/" , nomBarr + "-CjtElem");
    }
    
    
    /**
     * Lectura de datos persistentes del disco, lee el Conjunto de Restricciones
     * guardado en el disco que le corresponde al barrio con el nombre nomBarr, 
     * que le llega como parametro, y las pasa al TreeMap CjtRest que le llega
     * como parametro.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura del 
     * Conjunto de Restricciones.
     * @return El TreeMap de Restricciones con las restricciones leidas del 
     * disco. 
     */
    public TreeMap<String,Restriccion> leerCjtRest(String nomBarr){
        return (TreeMap<String,Restriccion>) 
                PERSDisco.leerObjeto(nomBarr + "/" , nomBarr + "-CjtRest");
    }
    
    
    /**
     * Lectura de datos persistentes del disco, lee el Plano guardado en el 
     * disco que le corresponde al barrio con el nombre nomBarr, que le llega 
     * como parametro, y lo pasa al Plano Mapa que le llega como parametro.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura del 
     * Plano.
     * @return El Plano con el mapa del barrio leido del disco.  
     */
    public Plano leerMapa(String nomBarr){
        return (Plano) 
                PERSDisco.leerObjeto(nomBarr + "/" , nomBarr + "-Mapa");
    }
    
    
    /**
     * Lectura de datos persistentes del disco, lee el Plano guardado en el 
     * disco que le corresponde al barrio con el nombre nomBarr, que le llega 
     * como parametro, y lo pasa al Plano Mapa que le llega como parametro.
     * @param nomBarr Nombre del Barrio del que se solicita la lectura del 
     * Plano.
     * @return El Plano con la copia de mapa del barrio leido del disco.  
     */
    public Plano leerCopiaMapa(String nomBarr){
        return (Plano) 
                PERSDisco.leerObjeto(nomBarr + "/" , nomBarr + "-MapaCopia");
    }
    
    
    
    /////ESCRITURAS AL DISCO/////   
    
    /**
     * escritura de datos persistentes del disco, escribe al disco los datos del
     * barrio con el nombre nomBarr, que le llega como parametro.
     * @param nomBarr Nombre del Barrio del cual se escriben los datos.
     * @param Bar El Barrio que se quiere escribir al disco.
     */     
    public void escribirBarrio(String nomBarr, Barrio Bar){
        PERSDisco.escribirObjeto(nomBarr + "/" , nomBarr + "-Barrio",Bar);
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
    public void escribirCjtElem(String nomBarr, Cjt_Edificios CjtElem){
        PERSDisco.escribirObjeto(nomBarr + "/" , nomBarr + "-CjtElem",CjtElem);
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
        PERSDisco.escribirObjeto(nomBarr + "/" , nomBarr + "-CjtRest",CjtRest);
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
        PERSDisco.escribirObjeto(nomBarr + "/" , nomBarr + "-Mapa", Mapa);
    }
    
    
    /**
     * Escritura de datos persistentes al disco, escribe el Plano Mapa que le 
     * llega como parametro, guardandolo en el disco como el que le corresponde 
     * al barrio con el nombre nomBarr, que le llega como parametro.
     * @param nomBarr Nombre del Barrio al que le corresponde el Plano que se va
     * guardar.
     * @param Mapa El Plano que se quiere guardar en el disco.
     */
    public void escribirCopiaMapa(String nomBarr, Plano Mapa){
        PERSDisco.escribirObjeto(nomBarr + "/" , nomBarr + "-MapaCopia", Mapa);
    }
    
    
     
    
}
