/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import elementos.Elemento;
import restricciones.Restriccion;
import java.util.TreeMap;

        

/**
 *
 * @author ArclorenSarth
 */
public class CtrlDomGeneral {
    private TreeMap<String,Elemento> TablaElem;
    private TreeMap<String,Restriccion> TablaRest;
    private TreeMap<String,Integer> TablaBarr;
    private stubbedElementosGDP GDPElem;
    private stubbedRestriccionesGDP GDPRest;
    private stubbedBarriosGDP GDPBarr;
    //private CtrlDomRestricciones DOMRest;
    private CtrlDomElementos DOMElem;
    private CtrlDomBarrios DOMBarr;
                
                
                
    
    /**
     * 
     */             
    public CtrlDomGeneral(){
        TablaElem = new TreeMap();
        TablaRest = new TreeMap();
        TablaBarr = new TreeMap();
        GDPElem = new stubbedElementosGDP();
        GDPRest = new stubbedRestriccionesGDP();
        GDPBarr = new stubbedBarriosGDP();
        //GDPElem.leerElementos(TablaElem);
        GDPRest.leerRestricciones(TablaRest);
        //DOMRest = new CtrlDomRestricciones(TablaRest);
        //DOMElem = new CtrlDomElementos(TablaElem);
        //DOMBarr = new CtrlDomBarrios(TablaElem,TablaRest,TablaBarr);
                 
    }
    
    public void CrearBarrio(String nombre){
        //DOMBarr.crearBarrio(nombre);
    }
    
    
    
}
