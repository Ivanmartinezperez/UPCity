/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;


import java.util.TreeMap;
import restricciones.Restriccion;
import elementos.Elemento;

/**
 *
 * @author ArclorenSarth
 */
public class CtrlDomBarrios {
    private TreeMap<String,Elemento> TablaElem;
    private TreeMap<String,Restriccion> TablaRest;
    
   
    /**
     * 
     * @param TE
     * @param TR 
     */
    public CtrlDomBarrios(TreeMap<String,Elemento> TE,
                          TreeMap<String,Restriccion> TR){
        
        TablaElem = TE;
        TablaRest = TR;
        
    }
    
    public void crearBarrio(String nombre, Integer poblacion, Integer presupuesto){
//        Esto de momento lo ire haciendo como lo veo, pero hay que dejar claro
//        la secuencia de entrada de datos y demas, que sino me lio :S
        
        
    }
    
    
    
}
