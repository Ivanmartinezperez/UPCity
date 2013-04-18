/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;


import Auxiliares.Pair;
import java.util.TreeMap;
import restricciones.Restriccion;
import elementos.*;
import elementos.Cjt_Elementos;
import barrio.Barrio;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author ArclorenSarth
 */
public class CtrlDomBarrios {
    
    private static CtrlDomBarrios INSTANCE;
    private TreeMap<String,Restriccion> TablaRest;
    private TreeMap<String,Integer> TablaBarr;
    private TreeMap<String,Elemento> mapElem0;
    private TreeMap<String,Elemento> mapElem1;
    private TreeMap<String,Elemento> mapElem2;
    private TreeMap<String,Elemento> mapElem3;
    private HashMap<Integer,ArrayList<Elemento>> mapTipoElem0;
    private HashMap<Integer,ArrayList<Elemento>> mapTipoElem1;
    private HashMap<Integer,ArrayList<Elemento>> mapTipoElem2;
    private HashMap<Integer,ArrayList<Elemento>> mapTipoElem3;
    private stubbedElementosGDP GDPElem;
    private stubbedRestriccionesGDP GDPRest;
    private stubbedBarriosGDP GDPBarr;
    
   
    /**
     * 
     */
    private CtrlDomBarrios(){
        mapElem0 = new TreeMap();
        mapElem1 = new TreeMap();
        mapElem2 = new TreeMap();
        mapElem3 = new TreeMap();
        mapTipoElem0 = new HashMap();
        mapTipoElem1 = new HashMap();
        mapTipoElem2 = new HashMap();
        mapTipoElem3 = new HashMap();
        TablaRest = new TreeMap();
        TablaBarr = new TreeMap();
        GDPElem = stubbedElementosGDP.getInstance();
        GDPRest = stubbedRestriccionesGDP.getInstance();
        GDPBarr = stubbedBarriosGDP.getInstance();
        GDPElem.leerElementos(mapElem0,mapTipoElem0,mapElem1,mapTipoElem1,mapElem2,
                              mapTipoElem2,mapElem3,mapTipoElem3);
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
    
    
    public Barrio crearBarrio(String nombre, int tip){
//        Esto basicamente creara un barrio temporal, consultando que el nombre
//        no este en uso y podra guardar el barrio, pero de momento es temporal,
//        hasta que el usuario diga de guardarlo despues de todas las 
//        operaciones sobre el
        
        Barrio b = null;
        if(TablaBarr.get(nombre)==null){
            b = new Barrio(nombre,tip);            
        }
        
        return b;
               
    }
    
    
    public boolean anadirRestBarrio(Barrio B, String Rest){
        if(TablaRest.containsKey(Rest)){
            B.putRestriccion(Rest);
            return true;
        }
        else return false;
    }
    
    public boolean anadirElemBarrio(Barrio B, String Elem, int cant){
        int tipo = B.getTipoBarrio();
        boolean b = false;
        Pair v;
        int oid;
        Elemento e = null;
        int gasto;
        
        if(mapElem0.containsKey(Elem))
            e = mapElem0.get(Elem);
        else {
            switch(tipo){
                case 0: if(mapElem1.containsKey(Elem))
                            e = mapElem1.get(Elem);
                        else if(mapElem2.containsKey(Elem))
                            e = mapElem2.get(Elem);
                        else if(mapElem3.containsKey(Elem))
                            e = mapElem3.get(Elem);
                case 1: if(mapElem1.containsKey(Elem))
                            e = mapElem1.get(Elem);
                case 2: if(mapElem2.containsKey(Elem))
                            e = mapElem2.get(Elem);
                case 3: if(mapElem3.containsKey(Elem))
                            e = mapElem3.get(Elem);
            }
        }
        if(e != null) {
            oid = e.getId();
            v = new Pair(cant,e);
            if(e instanceof Vivienda){
                Vivienda e2 = (Vivienda) e;
                gasto = cant * e2.getPrecio();
            }
            else if(e instanceof Publico){
                Publico e2 = (Publico) e;
                gasto = cant * e2.getPrecio();
            }
            else {
                Comercio e2 = (Comercio) e;
                gasto = cant * e2.getPrecio();
            }
            B.anadirGasto(gasto);
            B.putElemento(oid,v);
            b = true;
        }
        return b;
    }
    
    
//   ESTAS 2 Estaban en el Ctrl de elementos, de momento los puse aqui para 
//    reciclar codigo mas que nada
    
    /**
     * Crea un conjunto vacio y lo añade a las estructuras
     * @param Nombre Nombre del conjunto a crear
     * @return Devuelve true si todo se ha realizado correctamente
     */
    public boolean CrearConjunto(String Nombre){

        Cjt_Elementos cjt = new Cjt_Elementos();
        //mapCjtElem.put(Nombre, cjt);
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
            
            if(true/*mapElem.containsKey(e.getNom()) && mapCjtElem.containsKey(Nombre)*/){
                Pair p = new Pair(cantidad,e);
                //mapCjtElem.get(Nombre).insertar_elementos(e.getId(), p);
                return true;
            }
            return false;
        }
}
