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
import mapa.Plano;

/**
 *
 * @author ArclorenSarth
 */
public class CtrlDomBarrios {
    
    private static CtrlDomBarrios INSTANCE;
    private TreeMap<String,Integer> TablaBarrios;
    private Barrio B;
    private Cjt_Elementos CjtElem;
    private TreeMap<String,Restriccion> CjtRest;
    private Plano Mapa;
    private CtrlDomRestricciones DOMRest;
    private CtrlDomElementos DOMElem;
    private stubbedElementosGDP GDPElem;
    private stubbedRestriccionesGDP GDPRest;
    private stubbedBarriosGDP GDPBarr;
    
   
    /**
     * 
     */
    private CtrlDomBarrios(){
        TablaBarrios = new TreeMap();
        DOMElem = CtrlDomElementos.getInstance();
        DOMRest = CtrlDomRestricciones.getInstance();
        GDPElem = stubbedElementosGDP.getInstance();
        GDPRest = stubbedRestriccionesGDP.getInstance();
        GDPBarr = stubbedBarriosGDP.getInstance();
    }
    
    private static void creaInstancia() {
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
    
    
    public boolean crearBarrio(String nombre, int tip){
        if(!TablaBarrios.containsKey(nombre) && tip>0 && tip<=3){
            B = new Barrio(nombre,tip);
            CjtElem = new Cjt_Elementos();
            CjtRest = new TreeMap();
            return true;
        }
        else return false;
    }
    
    public boolean crearMapaBarrio(int n, int m){
        if(n>=1 && m>=1){
            Mapa = new Plano(n,m);
            return true;
        }
        else return false;
    }
    
    
    private void putRestriccion(String Rest, Restriccion r){
        CjtRest.put(Rest,r);
    }
    
    public boolean anadirRestBarrio(Barrio B, String Rest){
        Restriccion r;
        if(DOMRest.getRestriccion(Rest) = r){
            putRestriccion(Rest,r);
            return true;
        }
        else return false;
    }
    
    private void removeElemento(int oid, int catn){
        if(CjtElem.containsKey(oid)){
            CjtElem.eliminar_cantidad_elementos(oid, catn);         
            
        }
    }
    
    
    private void putElemento(int oid, Pair<Integer,Elemento> val){
        if(CjtElem.containsKey(oid)){
            int c = val.getFirst();
            CjtElem.anadir_cantidad_elementos(oid, c);
        }
        else{
            CjtElem.insertar_elementos(oid, val);           
        }        
    }
    
    private void guardarElemento(Barrio B, Elemento e, int cant){
        int gasto;
        int oid = e.getId();
        Pair v = new Pair(cant,e);
        if(e instanceof Vivienda){
            Vivienda e2 = (Vivienda) e;
            gasto = cant * e2.getPrecio();
            B.anadirHabitantes(e2.Getcap_max());
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
        putElemento(oid,v);
    }
    
    public boolean anadirElemBarrio(String Elem, int cant){
        int tipo = B.getTipoBarrio();
        boolean b = false;
        Elemento e;
        int tipoel;
        e = DOMElem.getElemento(Elem);
        if(e != null){
            tipoel = DOMElem.getTBElemento(e);
            switch(tipo){
                    case 0: b = true;
                    case 1: b = (tipoel==1 || tipoel==0);
                    case 2: b = (tipoel==2 || tipoel==0);
                    case 3: b = (tipoel==3 || tipoel==0);
            }
            if(b) guardarElemento(B,e,cant);
        }
        return b;
    }
    
    
    public boolean quitarElemento(String Elem, int cant){
        
    }
    
    public void modificarPlano(){
//        esta esta por si un caso, no creo que haga falta,
    }
    
    
    private void backFUCKINGtrackingBITCH(){
//        privada que hara el back-fucking-mother-fucking-tracking!!!
//        Aqui tienes que ponerlo Dani, pero avisa antes, sino, nos joderemos
//        faena!!!
    }
    
    public void generarBarrio(){
//        Esta sera la que se encargara de preparar el backtracking y SUPONGO
//        la que reviara condiciones previas a la generacion etc!
        
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
