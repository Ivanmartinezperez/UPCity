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
    private static CtrlDomRestricciones INSTANCE;
    
    /**
     * Creadora de la clase controlador de dominio de restricciones
     * @param ubicacion estructura que contiene las restricciones de ubicacion
     * @param demografica estructura que contiene las restricciones demograficas
     */
    private CtrlDomRestricciones(){
        RestGDP = stubbedRestriccionesGDP.getInstance();
        RestGDP.leerRestricciones(restubicacion);
        DOMElem = CtrlDomElementos.getInstance();
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
    
    /**
     * Encargado de crear una restriccion e ingresarla en la estructura deseada
     * @param id id de la nueva restriccion
     * @param tipo tipo de restriccion
     * @param OID1 se utiliza en el caso de crear restriccion de ubicacion y 
     * restriccion demografica. Es el id del primer elemento en caso de 
     * ubicacion y es el id del elemento a restringir en caso demografica
     * @param OID2 se utiliza solo en el caso de crear restriccion de ubicacion.
     * Es el id del segundo elemento
     * @param aux1 en caso ubicacion es la distancia, en caso demografica es 
     * habitantes, y en caso economica es cantidad de dinero para comercios
     * @param aux2 se utiliza solo en caso de restriccion economica. Es la 
     * cantidad de dinero que se utliza en viviendas 
     * @param aux3 se utiliza solo en caso de restriccion economica. Es la 
     * cantidad de dinero que se utliza en servicios publicos
     * @return retorna booleano si se ha hecho la creacion e insercion 
     * correctamente
     */
    public boolean CrearRestriccion(String id, String tipo, Integer OID1, 
                                    Integer OID2, int aux1, int aux2, int aux3){
        
        boolean ret = true;
        if(restubicacion.containsKey(id) || resteconomica.containsKey(id) ||
           restdemografica.containsKey(id)) 
            return false;
        
         
        switch(tipo){
            case "ubicacion":   
                if(DOMElem.existsElemento(OID1)&& DOMElem.existsElemento(OID2)
                   && aux1 >= 0){                   
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
                if(DOMElem.existsElemento(OID1) && aux1 >= 0){
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
        boolean ret = true;
        if(restubicacion.containsKey(id)){
            if(!RestGDP.existeRestEnBarrios(id)){
                restubicacion.remove(id);
                RestGDP.eliminarElemDisco(id);
            }
            else ret = false;
        }
        else if(resteconomica.containsKey(id)){
            if(!RestGDP.existeRestEnBarrios(id)){
                resteconomica.remove(id);
                RestGDP.eliminarElemDisco(id);
            }
            else ret = false;
        }
        else if(restdemografica.containsKey(id)) {
            if(!RestGDP.existeRestEnBarrios(id)){
                restdemografica.remove(id);
                RestGDP.eliminarElemDisco(id);
            }
            else ret = false;
        }
        return ret;
        
    }
    
    
    /**
     * Listado de instancias Restricciones del sistema.
     * @return Devuelve un Array de Restricciones del sistema.
     */
    public ArrayList<Restriccion> ListaRestricciones(){
             
            ArrayList<Restriccion> aux = new ArrayList();
            aux.addAll((ArrayList<Restriccion_ubicacion>) restubicacion.values());
            aux.addAll((ArrayList<Restriccion_economica>) resteconomica.values());
            aux.addAll((ArrayList<Restriccion_demografica>) restdemografica.values());
            return aux;
            
         }
    
    
    /**
     * Listado de instancias de un tipo determinado de Restricciones del sistema
     * @param tipo El nombre del tipo de Restricciones que se desea
     * @return 
     */
    public ArrayList<Restriccion> ListaRestriccionesTipo(String tipo){
             
            ArrayList<Restriccion> aux = new ArrayList();
            
            switch(tipo){
            case "ubicacion":
                aux.addAll((ArrayList<Restriccion_ubicacion>) restubicacion.values());
                break;
            case "economica":
            aux.addAll((ArrayList<Restriccion_economica>) resteconomica.values());
                break;
            case "demografica":
                aux.addAll((ArrayList<Restriccion_demografica>) restdemografica.values());
                break;
            }
            return aux;
            
         }
         
         
     /**
      * Listado de nombres de las restricciones del sistema
      * @return Devuelve un set con los nombres de las restricciones del 
      * sistema 
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
     * Listado de nombres de un tipo determinado de Restricciones del sistema
     * @param tipo El nombre del tipo de Restricciones que se desea
     * @return 
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

