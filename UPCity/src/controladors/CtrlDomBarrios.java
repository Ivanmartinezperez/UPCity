/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;


import Auxiliares.Pair;
import java.util.TreeMap;
import restricciones.Restriccion;
import elementos.Elemento;
import elementos.Cjt_Elementos;
import barrio.Barrio;


/**
 *
 * @author ArclorenSarth
 */
public class CtrlDomBarrios {
    
    private static CtrlDomBarrios INSTANCE;
    private TreeMap<String,Elemento> TablaElem;
    private TreeMap<String,Restriccion> TablaRest;
    private TreeMap<String,Integer> TablaBarr;
    private stubbedElementosGDP GDPElem;
    private stubbedRestriccionesGDP GDPRest;
    private stubbedBarriosGDP GDPBarr;
    
   
    /**
     * 
     */
    private CtrlDomBarrios(){
        TablaElem = new TreeMap();
        TablaRest = new TreeMap();
        TablaBarr = new TreeMap();
        GDPElem = stubbedElementosGDP.getInstance();
        GDPRest = stubbedRestriccionesGDP.getInstance();
        GDPBarr = stubbedBarriosGDP.getInstance();
        GDPElem.leerElementos(TablaElem);
        GDPRest.leerRestricciones(TablaRest);
        
    }
    
    private synchronized static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new CtrlDomBarrios();
        }
    }

    public static CtrlDomBarrios getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }
    
    
    public Barrio crearBarrio(String nombre){
//        Esto basicamente creara un barrio temporal, consultando que el nombre
//        no este en uso y podra guardar el barrio, pero de momento es temporal,
//        hasta que el usuario diga de guardarlo despues de todas las 
//        operaciones sobre el
        
        Barrio b = null;
        if(TablaBarr.get(nombre)==null){
            b = new Barrio(nombre);            
        }
        
        return b;
               
    }
    
    
   
    
    /**
     * Crea un conjunto vacio y lo añade a las estructuras
     * @param Nombre Nombre del conjunto a crear
     * @return Devuelve true si todo se ha realizado correctamente
     */
    public boolean CrearConjunto(String Nombre){

        Cjt_Elementos cjt = new Cjt_Elementos();
        mapCjtElem.put(Nombre, cjt);
        return true;

    }
    
    
    
    /**
     * Añade la cantidad de elemento especificada al conjunto especificado
     * @param Nombre
     * @param e
     * @param cantidad
     * @return Devuelve true en caso de que todo se reaize correctamente
     */
    public boolean Anadir_elemento_al_conjunto(String Nombre,Elemento e, Integer cantidad){
            
            if(mapElem.containsKey(e.getNom()) && mapCjtElem.containsKey(Nombre)){
                Pair p = new Pair(cantidad,e);
                mapCjtElem.get(Nombre).insertar_elementos(e.getId(), p);
                return true;
            }
            return false;
        }
}
