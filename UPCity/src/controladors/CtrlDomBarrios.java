/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;


import Auxiliares.Pair;
import java.util.TreeMap;
import restricciones.*;
import elementos.*;
import elementos.Cjt_Elementos;
import barrio.Barrio;
import java.util.ArrayList;
import java.util.HashMap;
import mapa.Plano;

/**
 *
 * @author ArclorenSarth
 */
public class CtrlDomBarrios {
    
    private static CtrlDomBarrios INSTANCE=null;
    private TreeMap<String,Integer> TablaBarrios;
    private Barrio B;
    private Cjt_Elementos CjtElem;
    private TreeMap<String,Restriccion> CjtRest;
    private HashMap<Integer,ArrayList<Restriccion_ubicacion>> CjtRestUbic1;
    private HashMap<Integer,ArrayList<Restriccion_ubicacion>> CjtRestUbic2;
    private HashMap<Integer,Restriccion_demografica> CjtRestDemog;
    private Restriccion_economica RestEcon;
    private Plano Mapa;
    private CtrlDomRestricciones DOMRest;
    private CtrlDomElementos DOMElem;
    private stubbedElementosGDP GDPElem;
    private stubbedRestriccionesGDP GDPRest;
    private stubbedBarriosGDP GDPBarr;
    
   
    /////CREADORA/////
    
    /**
     * Creadora del Controlador de Dominio de Barrios.
     */
    private CtrlDomBarrios(){
        TablaBarrios = new TreeMap();
        DOMElem = CtrlDomElementos.getInstance();
        DOMElem.inicializar();
        DOMRest = CtrlDomRestricciones.getInstance();
        DOMRest.inicializar();
        GDPElem = stubbedElementosGDP.getInstance();
        GDPRest = stubbedRestriccionesGDP.getInstance();
        GDPBarr = stubbedBarriosGDP.getInstance();
        GDPBarr.leerBarriosCreados(TablaBarrios);
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
    
    
    /////PUBLICAS/////
    
    /**
     * Crea un barrio con el Nombre que le llega como parametro nombre y el tipo
     * de barrio tip, que le llega como parametro.
     * @param nombre Nombre que se quiere poner al nuevo barrio que se crea.
     * @param tip Tipo de Barrio que tendra el nuevo barrio que se crea.
     * @return Retorna si ha sido posible crear el barrio, cierto si no existe
     * un barrio con ese nombre todavia y falso si ese barrio existe.
     */
    public boolean crearBarrio(String nombre, int tip){
        if(!TablaBarrios.containsKey(nombre) && tip>=0 && tip<=3){
            B = new Barrio();
            CjtElem = new Cjt_Elementos();
            CjtRest = new TreeMap();
            CjtRestUbic1 = new HashMap();
            CjtRestUbic2 = new HashMap();
            CjtRestDemog = new HashMap();
            RestEcon = new Restriccion_economica();
            Mapa = new Plano();
            B.setNombreBarrio(nombre);
            B.setTipoBarrio(tip);
            return true;
        }
        else return false;
    }
    
    
    /**
     * Carga un barrio previamente creado con el Nombre que le llega como 
     * parametro nombre.
     * @param nombre Nombre del barrio que se quiere cargar.
     * @return Retorna si ha sido posible cargar el barrio, cierto si existe el 
     * barrio con ese nombre y falso si ese barrio no existe.
     */
    public boolean cargarBarrio(String nombre){
        if(TablaBarrios.containsKey(nombre)){
            B = new Barrio();
            CjtElem = new Cjt_Elementos();
            CjtRest = new TreeMap();
            CjtRestUbic1 = new HashMap();
            CjtRestUbic2 = new HashMap();
            CjtRestDemog = new HashMap();
            RestEcon = new Restriccion_economica();
            Mapa = new Plano();
            GDPBarr.leerBarrio(nombre,B);
            GDPBarr.leerMapa(nombre,Mapa);
            GDPBarr.leerCjtRest(nombre,CjtRest);
            transRestBarrio();
            GDPBarr.leerCjtElem(nombre,CjtElem);
            return true;
        }
        else return false;
    }
    
    
    /**
     * Guarda el barrio sobre el cual se estaba trabajando, ya sea uno cargado
     * previamente o uno nuevo creado.
     */
    public void guardarBarrio(){
        String nombre = B.getNombreBarrio();
        TablaBarrios.put(nombre,(Integer) 1);
        GDPBarr.escribirBarrio(nombre,B);
        GDPBarr.escribirMapa(nombre,Mapa);
        GDPBarr.escribirCjtRest(nombre,CjtRest);
        GDPBarr.escribirCjtElem(nombre,CjtElem);
    }
    
    
    /**
     * Crea un Plano que se le asignara a un barrio acabado de crear, con las
     * dimensiones n y m que le llegan como parametros.
     * @param n Numero de filas que tendra el Plano.
     * @param m Numero de columnas que tendra el Plano
     * @return Retorna si ha sido posible crear el plano.
     */
    public boolean crearMapaBarrio(int n, int m) throws Exception{
        if(n>=1 && m>=1){
            Mapa = new Plano(n,m);
            return true;
        }
        else return false;
    }
    
    
    /**
     * Añade la Restriccion con el nombre Rest, que le llega como parametro, al
     * Conjunto de Restricciones del barrio sobre el que se trabaja.
     * @param Rest Nombre de la Restriccion que se quiere añadir.
     * @return Retorna si se ha podido añadir la Restriccion deseada, cierto si
     * esa Restriccion existe y falso si esa Restriccion no existe.
     */
   public boolean anadirRestBarrio(String Rest){
        Restriccion r = DOMRest.getRestriccion(Rest);
        if(r != null){
            CjtRest.put(Rest,r);
            putRestriccion(r);
            return true;
        }
        else return false;
    }
    
    
    /**
     * Elimina la Restriccion con el nombre Rest del Conjunto de Restricciones
     * del barrio sobre el que se trabaja.
     * @param Rest Nombre de la restriccion que se quiere eliminar.
     * @return Retorna si se ha podido eliminar la Restriccion deseada, cierto
     * si la Restriccion existe en el Conjunto de Restricciones del Barrio o
     * falso si dicha Restriccion no existe en el Conjunto.
     */
    public boolean quitarRestBarrio(String Rest){
        if(CjtRest.containsKey(Rest)){
            Restriccion r = CjtRest.get(Rest);
            removeRestriccion(r);
            CjtRest.remove(Rest);
            return true;
        }
        else return false;
    }
    
    
    /**
     * Añade cant Elementos con el nombre Elem al barrio sobre el que se
     * trabaja, ambos pasados como parametros a la funcion.
     * @param Elem Nombre del Elemento que se quiere añadir al barrio.
     * @param cant Cantidad del Elemento que se quiere añadir.
     * @return Retorna si ha sido posible añadir el Elemento deseado, cierto si
     * el Elemento existe y su tipo sea compatible con el Tipo de Barrio del 
     * Barrio sobre el que se trabaja o falso si el Elemento no existe o no es
     * compatible con el Tipo de Barrio del Barrio sobre el que se trabaja.
     */
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
            if(b) guardarElemento(e,cant);
        }
        return b;
    }
    
    
    /**
     * Elimina cant elementos con el nombre de Elemento Elem, pasado por 
     * parametro, del Barrio sobre el que se trabaja. Tambien actualiza la 
     * informacion relacionada con ese Elemento dentro del Barrio sobre el que 
     * se trabaja.
     * @param Elem Nombre del Elemento que se quiere eliminar.
     * @param cant Cantidad del Elemento que se quiere eliminar.
     * @return Retorna si se ha podido eliminar el Elemento deseado del Barrio,
     * cierto si ese elemento existe en el Conjunto de Elementos del Barrio o 
     * falso si no existe.
     */
    public boolean quitarElemento(String Elem, int cant){
        Elemento e = DOMElem.getElemento(Elem);
        int oid = e.getId();
        if(CjtElem.containsKey(oid)){
            Pair valor = (Pair) CjtElem.get(oid);
            int cantreal = (int) valor.getFirst();
            if (cantreal<cant) cant = cantreal;
            int gasto;
            if(e instanceof Vivienda){
                Vivienda e2 = (Vivienda) e;
                gasto = cant * e2.getPrecio();
                B.anadirHabitantes(-(e2.Getcap_max()));
            }
            else if(e instanceof Publico){
                Publico e2 = (Publico) e;
                gasto = cant * e2.getPrecio();
            }
            else {
                Comercio e2 = (Comercio) e;
                gasto = cant * e2.getPrecio();
                B.anadirComercio(-(e2.getCapacidad()));
            }
            B.anadirGasto(-gasto);
            removeElemento(oid,cant);
            
            return true;           
        }
        else return false;
    }
    
    
    
    
    
    /////PRIVADAS/////
    
    
    /**
     * Funcion privada que reparte la informacion del CjtRest previamente
     * cargado del disco de un barrio ya creado, entre las estructuras de 
     * Restricciones utilizadas en el Controlador.
     */
    private void transRestBarrio(){
        ArrayList<Restriccion> aux = new ArrayList();
        aux.addAll((ArrayList<Restriccion>) CjtRest.values());
        Restriccion r;
        for (int i=0; i<aux.size(); ++i){
            r = aux.get(i);
            putRestriccion(r);
        }
    }
    
    
    /**
     * Añande la Restriccion r, que le llega como parametro, a las estructuras
     * de restricciones utilizadas por el Controlador.
     * @param r Restriccion que se quiere añadir a las estructuras.
     */
    private void putRestriccion(Restriccion r){
        ArrayList<Restriccion_ubicacion> aux2;
        if(r instanceof Restriccion_ubicacion){
            Restriccion_ubicacion r2 = (Restriccion_ubicacion) r;
            int oid1 = r2.consultar_OID1();
            int oid2 = r2.consultar_OID2();
            Restriccion_ubicacion r3 = new Restriccion_ubicacion(r2.getId(),
                         r2.getTypeSU(),oid2,oid1,r2.consultar_distancia());
            
            if(CjtRestUbic1.containsKey(oid1))
                aux2 = CjtRestUbic1.get(oid1);
            else
                aux2 = new ArrayList();
            aux2.add(r2);
            CjtRestUbic1.put((Integer) oid1, aux2);

            if(CjtRestUbic2.containsKey(oid2))
                aux2 = CjtRestUbic2.get(oid2);
            else
                aux2 = new ArrayList();
            aux2.add(r3);
            CjtRestUbic2.put((Integer) oid2, aux2);
        }
        else if(r instanceof Restriccion_demografica){
            Restriccion_demografica r2 = (Restriccion_demografica) r;
            CjtRestDemog.put(r2.consultar_OID(), r2);
        }
        else if(r instanceof Restriccion_economica)
            RestEcon = (Restriccion_economica) r;
        
    }
    
    
    /**
     * Funcion privada que elimina una determianda Restriccion de las 
     * estructuras de Restricciones del Controlador.
     * @param r Restriccion que queremos eliminar.
     */
    private void removeRestriccion(Restriccion r){
        ArrayList<Restriccion_ubicacion> aux2;
        if(r instanceof Restriccion_ubicacion){
            Restriccion_ubicacion r2 = (Restriccion_ubicacion) r;
            int oid1 = r2.consultar_OID1().intValue();
            int oid2 = r2.consultar_OID2().intValue();
                      
            aux2 = CjtRestUbic1.get(oid1);
            aux2.remove(searchRestUbic(oid2,aux2));
            CjtRestUbic1.put((Integer) oid1, aux2);
            aux2 = CjtRestUbic2.get(oid2);
            aux2.remove(searchRestUbic(oid1,aux2));
            CjtRestUbic2.put((Integer) oid2, aux2);
        }
        else if(r instanceof Restriccion_demografica){
            Restriccion_demografica r2 = (Restriccion_demografica) r;
            CjtRestDemog.remove(r2.consultar_OID());
        }
        else if(r instanceof Restriccion_economica)
            RestEcon = null;
    }
    
    
    /**
     * Funcion privada que busca en un ArrayList que indice tiene la restriccion
     * de ubicacion con OID2 igual al oid que le proporcionan.
     * @param oid OID2 de la restriccion que buscamos.
     * @param aux ArrayList donde buscamos la Restriccion.
     * @return 
     */
    private int searchRestUbic(int oid,ArrayList<Restriccion_ubicacion> aux){
        for(int i = 0; i<aux.size(); ++i){
            if(aux.get(i).consultar_OID2()==oid){
                return i;
            }
        }
        return 0;
    }
    
    /**
     * Añade el Elemento con el oid, que le llega como parametro, al 
     * Cjt_Elementos del barrio sobre el que se trabaja.
     * @param oid Identificador numerico del elemento que se quiere añadir.
     * @param val El Elemento junto con la cantidad de ese elemento que se 
     * quiere añadir
     */
    private void putElemento(int oid, Pair<Integer,Elemento> val){
        if(CjtElem.containsKey(oid)){
            int c = val.getFirst();
            CjtElem.anadir_cantidad_elementos(oid, c);
        }
        else{
            CjtElem.insertar_elementos(oid, val);           
        }        
    }
    
    
    /**
     * Guarda toda la informacion relacionada con el Elemento e y la cantidad 
     * cant que se quiere añadir, pasados como parametros, en el barrio sobre el
     * que se trabaja y lo añade a su Conjunto de Elementos. La informacion 
     * relacionada con el elemento es por ejemplo su precio y la capacidad de
     * habitantes si es una Vivienda, esta informacion sera pasada al barrio
     * para que la guarde.
     * @param e Elemento que se quiere añadir.
     * @param cant Cantidad del Elemento que se quiere añadir.
     */
    private void guardarElemento(Elemento e, int cant){
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
            B.anadirComercio(e2.getCapacidad());
        }
        B.anadirGasto(gasto);
        putElemento(oid,v);
    }
    
    
    /**
     * Elimina cant Elementos con oid que se le pasa por parametro del 
     * Cjt_Elementos del barrio sobre el que se trabaja.
     * @param oid Identificador numerico del Elemento que se quiere eliminar.
     * @param catn Cantidad de Elementos con el oid deseado que se quieren 
     * eliminar 
     */
    private void removeElemento(int oid, int catn){
        if(CjtElem.containsKey(oid)){
            CjtElem.eliminar_cantidad_elementos(oid, catn);         
            
        }
    }


}
