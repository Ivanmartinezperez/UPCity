/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import java.util.*;
import restricciones.*;
import Auxiliares.*;
/**
 *
 * @author ron y ArclorenSarth
 */
public class CtrlDomRestricciones {
    private TreeMap<String, Restriccion_ubicacion> restubicacion;
    //private TreeMap<String, Restriccion_demografica> restdemografica;
    //private Pair<String,Restriccion_economica> resteconomica;
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
     * @param OID1 se utiliza en el caso de crear restriccion de ubicacion y restriccion demografica.
     * es el id del primer elemento en caso de ubicacion y es el id del elemento a restringir en caso demografica
     * @param OID2 se utiliza solo en el caso de crear restriccion de ubicacion. Es el id del segundo elemento
     * @param aux1 en caso ubicacion es la distancia, en caso demografica es habitantes, y en caso economica es cantidad
     * de dinero para comercios
     * @param aux2 se utiliza solo en caso de restriccion economica. Es la cantidad de dinero que se
     * utliza en viviendas
     * @param aux3 se utiliza solo en caso de restriccion economica. Es la cantidad de dinero que se
     * utliza en servicios publicos
     * @return retorna booleano si se ha hecho la creacion e insercion correctamente
     */
    public boolean CrearRestriccion(String id, String tipo, String OID1, String OID2, int aux1, int aux2, int aux3){
        boolean ret=true;
        switch(tipo){
            case "ubicacion":   Restriccion_ubicacion u = new Restriccion_ubicacion(id, tipo, OID1, OID2, aux1);
                                restubicacion.put(id, u);
                                break;
            case "economica":   resteconomica.setSecond(new Restriccion_economica(id, tipo, aux1, aux2, aux3));
                                resteconomica.setFirst(id);
                                break;
            case "demografica": Restriccion_demografica d = new Restriccion_demografica(id, tipo, OID1, aux1);
                                restdemografica.put(id, d);
                                break;
            default:            ret = false;
        }
        return ret;
    }
    
    /**
     * Encargado de modificar una restriccion ya creada
     * @param id id de la restriccion que hay que modificar
     * @param tipo tipo de la restriccion que hay que modificar
     * @param aux1 en caso ubicacion es la distancia nueva, en caso economica es la nueva cantidad de dinero
     * para invertir en comercios, en caso demografico es la nueva cantidad minima de habitantes
     * @param aux2 se utiliza solo en caso economica, es la nueva cantidad de dinero para viviendas
     * @param aux3 se utiliza solo en caso economica, es la nueva cantidad de dinero para servicios publicos
     * @return retorna booleano si se ha hecho la modificacion correctamente
     */
    public boolean ModificarRestriccion(String id, String tipo, int aux1, int aux2, int aux3){
        boolean ret=true;
        switch(tipo){
            case "ubicacion":   if(aux1 > 0 && restubicacion.containsKey(id)){
                                    Restriccion_ubicacion u = restubicacion.get(id);
                                    u.modificar_distancia(aux1);
                                }
                                else ret = false;
                                break;
            case "economica":   if (aux1 >= 0 && aux2 >= 0 && aux3 >= 0 && resteconomica.getFirst().equals(id)){
                                    Restriccion_economica e = resteconomica.getSecond();
                                    e.Modificarsaldo(aux1, aux2, aux3);
                                }
                                else ret = false;
                                break;
            case "demografica": if(aux1 >= 0 &&restdemografica.containsKey(id)){
                                    Restriccion_demografica d = restdemografica.get(id);
                                    d.modificar_habitantes(aux1);
                                }
                                else ret = false;
                                break;
            default:            ret = false;
            }
            return ret;
     }
    
    /**
     * Encargado de eliminar una restriccion de la estructura
     * @param id id de la restriccion que hay que eliminar
     * @param tipo tipo de la restriccion que hay que eliminar
     * @return retorna booleano si se ha hecho la eliminacion correctamente
     */
    public boolean Eliminar_Restriccion(String id, String tipo){
        boolean ret = true;
        switch(tipo){
                    case "ubicacion":   if(restubicacion.containsKey(id)) restubicacion.remove(id);
                                        else ret = false;
                                        break;
                    case "demografica": if(restdemografica.containsKey(id)) restdemografica.remove(id);
                                        else ret = false;
                                        break;
                    default:            ret = false;
                }
                
                return ret;
        
    }
}

