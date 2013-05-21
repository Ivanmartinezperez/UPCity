/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import restricciones.*;

/**
 *
 * @author ron y ArclorenSarth
 */
public class CtrlDomRestricciones {
    private TreeMap<String, Restriccion_ubicacion> restubicacion;
    private TreeMap<String, Restriccion_demografica> restdemografica;
    private TreeMap<String, Restriccion_economica> resteconomica;
    private CtrlDomElementos DOMElem;
    private stubbedRestriccionesGDP RestGDP;
    private static CtrlDomRestricciones INSTANCE=null;
    private static boolean init=false;
    
    
    /**
     * Creadora de la clase controlador de dominio de restricciones
     * @param ubicacion estructura que contiene las restricciones de ubicacion
     * @param demografica estructura que contiene las restricciones demograficas
     */
    private CtrlDomRestricciones(){
        RestGDP = stubbedRestriccionesGDP.getInstance();
        restubicacion = new TreeMap();
        restdemografica = new TreeMap();
        resteconomica = new TreeMap();
        ArrayList<Restriccion> restPers;
        restPers = RestGDP.leerRestricciones();
        for(int i=0; i<restPers.size(); ++i){
            Restriccion r = restPers.get(i);
            switch(r.getTypeSU()){
                case "ubicacion":
                    restubicacion.put(r.getId(),(Restriccion_ubicacion)r);
                    break;
                case "economica":
                    resteconomica.put(r.getId(),(Restriccion_economica)r);
                    break;
                case "demografica":
                    restdemografica.put(r.getId(),(Restriccion_demografica)r);
                    break;
            }
        }
    }
    
    
    private static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new CtrlDomRestricciones();
        }
    }

    public static CtrlDomRestricciones getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }
    
    public void inicializar(){
        if(!init){
            init = true;
            DOMElem = CtrlDomElementos.getInstance();
            DOMElem.inicializar();
        }
    }
    
    
    /**
     * Encargado de crear una restriccion e ingresarla en la estructura deseada
     * @param id id de la nueva restriccion
     * @param tipo tipo de restriccion
     * @param nombre1 se utiliza en el caso de crear restriccion de ubicacion y 
     * restriccion demografica. Es el nombre del primer elemento en caso de 
     * ubicacion y es el nombre del elemento a restringir en caso demografica
     * @param nombre2 se utiliza solo en el caso de crear restriccion de ubicacion.
     * Es el nombre del segundo elemento
     * @param aux1 en caso ubicacion es la distancia, en caso demografica es 
     * habitantes, y en caso economica es cantidad de dinero para comercios
     * @param aux2 se utiliza solo en caso de restriccion economica. Es la 
     * cantidad de dinero que se utliza en viviendas 
     * @param aux3 se utiliza solo en caso de restriccion economica. Es la 
     * cantidad de dinero que se utliza en servicios publicos
     * @return retorna booleano si se ha hecho la creacion e insercion 
     * correctamente
     */
    public boolean CrearRestriccion(String id, String tipo, String nombre1, 
                                    String nombre2, int aux1, int aux2, int aux3){
        
        boolean ret = true;
        if(restubicacion.containsKey(id) || resteconomica.containsKey(id) ||
           restdemografica.containsKey(id)) 
            return false;
        
        Integer OID1 = DOMElem.getOID(nombre1);
        Integer OID2 = DOMElem.getOID(nombre2); 
        switch(tipo){
            case "ubicacion":   
                if(OID1!=null && OID2 != null && aux1 >= 0){
                    
                    Restriccion_ubicacion u = new Restriccion_ubicacion(id, 
                                                  tipo,OID1, OID2, aux1);
                    restubicacion.put(id, u);
                    RestGDP.escribirRestriccion(u);
                }
                else ret = false;
                break;
            
            case "economica":   
                if(aux1 >= 0 && aux2 >= 0 && aux3 >= 0){
                    Restriccion_economica e = new Restriccion_economica(id, 
                                                  tipo,aux1, aux2, aux3);
                    resteconomica.put(id, e);
                    RestGDP.escribirRestriccion(e);
                }
                else ret = false;
                break;
            
            case "demografica": 
                if(OID1 != null && aux1 >= 0){
                    Restriccion_demografica d = new Restriccion_demografica(id, 
                                                tipo, OID1, aux1);
                    restdemografica.put(id, d);
                    RestGDP.escribirRestriccion(d);
                }
                else ret = false;
                break;
            
            default: ret = false;
        }
        return ret;
    }
       
    
    /**
     * Encargado de modificar una restriccion ya creada
     * @param id id de la restriccion que hay que modificar
     * @param tipo tipo de la restriccion que hay que modificar
     * @param aux1 en caso ubicacion es la distancia nueva, en caso economica 
     * es la nueva cantidad de dineropara invertir en comercios, en caso 
     * demografico es la nueva cantidad minima de habitantes.
     * @param aux2 se utiliza solo en caso economica, es la nueva cantidad de 
     * dinero para viviendas.
     * @param aux3 se utiliza solo en caso economica, es la nueva cantidad de 
     * dinero para servicios publicos.
     * @return retorna booleano si se ha hecho la modificacion correctamente
     */
    public boolean ModificarRestriccion(String id, String tipo, int aux1, 
                                        int aux2, int aux3){
        boolean ret=true;
        switch(tipo){
            case "ubicacion":   
                if(aux1 > 0 && restubicacion.containsKey(id)){
                    Restriccion_ubicacion u = restubicacion.get(id);
                    u.modificar_distancia(aux1);
                }
                else ret = false;
                break;
            case "economica":
                if (aux1 >= 0 && aux2 >= 0 && aux3 >= 0 && 
                    resteconomica.containsKey(id)){
                    Restriccion_economica e = resteconomica.get(id);
                    e.Modificarsaldo(aux1, aux2, aux3);
                }
                else ret = false;
                break;
            case "demografica": 
                if(aux1 >= 0 && restdemografica.containsKey(id)){
                    Restriccion_demografica d = restdemografica.get(id);
                    d.modificar_habitantes(aux1);
                }
                else ret = false;
                break;
            default: ret = false;
            }
            return ret;
     }
    
    /**
     * Encargado de eliminar una restriccion de la estructura
     * @param id id de la restriccion que hay que eliminar
     * @param tipo tipo de la restriccion que hay que eliminar
     * @return retorna booleano si se ha hecho la eliminacion correctamente
     */
    public boolean Eliminar_Restriccion(String id){
        boolean ret = false;
        if(restubicacion.containsKey(id)){
            if(!RestGDP.existeRestEnBarrios(id)){
                restubicacion.remove(id);
                RestGDP.eliminarRestDisco(id);
                ret = true;
            }
            
        }
        else if(resteconomica.containsKey(id)){
            if(!RestGDP.existeRestEnBarrios(id)){
                resteconomica.remove(id);
                RestGDP.eliminarRestDisco(id);
                ret = true;
            }
            
        }
        else if(restdemografica.containsKey(id)) {
            if(!RestGDP.existeRestEnBarrios(id)){
                restdemografica.remove(id);
                RestGDP.eliminarRestDisco(id);
                ret = true;
            }
            
        }
        return ret;
        
    }
    
    
    /**
     * Funcion que busca la Restriccion con el nombre Rest entre las 
     * Restricciones dentro del sistema, si esta la retorna y si no esta 
     * retorna null.
     * @param Rest Nombre de la Restriccion deseada.
     * @return Retorna la Restriccion buscada si la ha encontrado, o sino 
     * retorna null.
     */
    public Restriccion getRestriccion(String Rest){
        Restriccion r = null;
        if(restubicacion.containsKey(Rest))
            r = restubicacion.get(Rest);
        else if(restdemografica.containsKey(Rest))
            r = restdemografica.get(Rest);
        else if(resteconomica.containsKey(Rest))
            r = resteconomica.get(Rest);
        return r;
    }
    
    
    /**
     * Funcion que comprueba si existe alguna Restriccion de ubicacion o 
     * demografica que se aplique sobre el Elemento con identificador ID.
     * @param ID Identificador del Elemento del cual comprobamos la existencia
     * de Restricciones.
     * @return Retorna si existe alguna Restriccion que se aplique al Elemento
     * con el identificador ID.
     */
    public boolean existeRestElem(Integer ID) throws Exception{
        boolean ret = false;
        ArrayList<Restriccion> Rest = new ArrayList();
        Rest.addAll(restubicacion.values());
        Rest.addAll(restdemografica.values());
        boolean b = false;
        String men = "\nExisten las siguientes restricciones "
                + "sobre el elemento:";
        for(int i = 0; i < Rest.size(); ++i){
            Restriccion r;
            r = Rest.get(i);
            if(r instanceof Restriccion_ubicacion){
                Restriccion_ubicacion r2 = (Restriccion_ubicacion) r;
                if(ID == r2.consultar_OID1() || ID == r2.consultar_OID2()){
                    b = true;
                    men = men.concat("\n" + r2.getId());
                }
            }
            else if(r instanceof Restriccion_demografica){
                Restriccion_demografica r2 = (Restriccion_demografica) r;
                if(ID == r2.consultar_OID()){
                    b = true;
                    men = men.concat("\n" + r2.getId());
                }
            }
        }
        men = men.concat("\nHa de eliminar las restricciones sobre el elemento "
                + "antes de poder eliminar el elemento completamente del sistema.");
        if(b)
            throw new Exception(men);
        return false;
    }
    
    
    /**
     * Array de instancias Restricciones del sistema.
     * @return Devuelve un Array de Restricciones del sistema.
     */
    private ArrayList<Restriccion> arrayRest(){
             
            ArrayList<Restriccion> aux = new ArrayList();
            aux.addAll(restubicacion.values());
            aux.addAll(resteconomica.values());
            aux.addAll(restdemografica.values());
            return aux;
            
         }
    
    
    /**
     * Array de instancias de un tipo determinado de Restricciones del sistema
     * @param tipo El nombre del tipo de Restricciones que se desea.
     * @return Devuelve un Array de Restricciones del tipo deseado.
     */
    private ArrayList<Restriccion> arrayRestTipo(String tipo){
             
            ArrayList<Restriccion> aux = new ArrayList();
            
            switch(tipo){
            case "ubicacion":
                aux.addAll(restubicacion.values());
                break;
            case "economica":
            aux.addAll(resteconomica.values());
                break;
            case "demografica":
                aux.addAll(restdemografica.values());
                break;
            }
            return aux;
            
    }
    
    
    /**
     * Funcion que lista un tipo de Restricciones que tiene el sistema.
     * @param tipo Tipo de Restricciones que se quiere listar.
     * @return Retorna un matriz de Strings que contiene los parametros de las
     * Restricciones deseadas.
     */
    public String[][] listarRestTipo(String tipo){
         ArrayList<Restriccion> rest = arrayRestTipo(tipo);
         String[][] mat = null;
         if(!rest.isEmpty()) mat = new String[rest.size()][5];
         Restriccion_ubicacion u;
         Restriccion_economica e;
         Restriccion_demografica d;
         
         for(int i=0; i<rest.size(); ++i){
             switch(tipo){
                 case "ubicacion":
                     u = (Restriccion_ubicacion) rest.get(i);
                     mat[i][0] = u.getId();
                     mat[i][1] = String.valueOf(DOMElem.NombreElemento(u.consultar_OID1()));
                     mat[i][2] = String.valueOf(DOMElem.NombreElemento(u.consultar_OID2()));
                     mat[i][3] = String.valueOf(u.consultar_distancia());
                     mat[i][4] = "-1";
                     break;

                 case "economica":
                     e = (Restriccion_economica) rest.get(i);
                     mat[i][0] = e.getId();
                     mat[i][1] = String.valueOf(e.consultar_saldo());
                     mat[i][2] = String.valueOf(e.consultar_saldo_ind(1));
                     mat[i][3] = String.valueOf(e.consultar_saldo_ind(2));
                     mat[i][4] = String.valueOf(e.consultar_saldo_ind(0));
                     break;

                 case "demografica":
                     d = (Restriccion_demografica) rest.get(i);
                     mat[i][0] = d.getId();
                     mat[i][1] = String.valueOf(DOMElem.NombreElemento(d.consultar_OID()));
                     mat[i][2] = String.valueOf(d.consultar_habitantes());
                     mat[i][3] = "-1";
                     mat[i][4] = "-1";
                     break;
             }
         }
         return mat;
    }
    
    
     /**
      * Listado de nombres de las restricciones del sistema.
      * @return Devuelve un set con los nombres de las restricciones del 
      * sistema. 
      */
     public Set<String> ListaNombreRestricciones(){

            Set<String> aux = new HashSet();
            if(!restubicacion.isEmpty())
                aux.addAll(restubicacion.keySet());
            if(!resteconomica.isEmpty())
                aux.addAll(resteconomica.keySet());
            if(!restdemografica.isEmpty())
                aux.addAll(restdemografica.keySet());

            return aux;
         }


     /**
      * Listado de nombres de un tipo determinado de Restricciones del sistema.
      * @param tipo El nombre del tipo de Restricciones que se desea.
      * @return Retorna un set de Restricciones de un determinado tipo.
      */
     public Set<String> ListaNombreRestriccionesTipo(String tipo){

            Set<String> aux = new HashSet();
            switch(tipo){
                    case "ubicacion":
                        if(!restubicacion.isEmpty())
                            aux.addAll(restubicacion.keySet());
                        break;
                    case "economica":
                        if(!resteconomica.isEmpty())
                            aux.addAll(resteconomica.keySet());
                        break;
                    case "demografica":
                        if(!restdemografica.isEmpty())
                            aux.addAll(restdemografica.keySet());
                        break;
            }

            return aux;
         }
         
    
    
    
}

