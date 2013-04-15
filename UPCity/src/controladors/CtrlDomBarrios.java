/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;


import java.util.TreeMap;
import restricciones.Restriccion;
import elementos.Elemento;
import barrio.Barrio;

/**
 *
 * @author ArclorenSarth
 */
public class CtrlDomBarrios {
    private TreeMap<String,Elemento> TablaElem;
    private TreeMap<String,Restriccion> TablaRest;
    private TreeMap<String,Integer> TablaBarr;
    private stubbedElementosGDP GDPElem;
    private stubbedRestriccionesGDP GDPRest;
    private stubbedBarriosGDP GDPBarr;
    
   
    /**
     * 
     */
    public CtrlDomBarrios(){
        TablaElem = new TreeMap();
        TablaRest = new TreeMap();
        TablaBarr = new TreeMap();
        GDPElem = new stubbedElementosGDP();
        GDPRest = new stubbedRestriccionesGDP();
        GDPBarr = new stubbedBarriosGDP();
        GDPElem.leerElementos(TablaElem);
        GDPRest.leerRestricciones(TablaRest);
        
    }
    
    public Barrio crearBarrio(String nombre){
//        Esto basicamente creara un barrio temporal, consultando que el nombre
//        no este en uso y podra guardar el barrio, pero de momento es temporal,
//        hasta que el usuario diga de guardarlo despues de todas las 
//        operaciones sobre el
        
        Barrio b;
        if(TablaBarr.get(nombre)==null){
            b = new Barrio(nombre);            
        }
        
        return b;
               
    }
    
    
    
}
