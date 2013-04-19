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
 * @author ron
 */
public class CtrlDomRestricciones {
    private TreeMap<String, Restriccion_ubicacion> restubicacion;
    private TreeMap<String, Restriccion_demografica> restdemografica;
    private Pair<String,Restriccion_economica> resteconomica;
    
    public CtrlDomRestricciones(TreeMap<String, Restriccion_ubicacion> ubicacion, TreeMap<String, Restriccion_demografica> demografica){
        restubicacion = ubicacion;
        restdemografica = demografica;
        
    }
    
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
    
    public boolean ModificarRestriccion(String id, String tipo, int aux1, int aux2, int aux3){
        boolean ret=true;
        switch(tipo){
            case "ubicacion":   if(aux1 > 0 && restubicacion.containsKey(id)){
                                    Restriccion_ubicacion u = restubicacion.get(id);
                                    u.modificar_distancia(aux1);
                                }
                                else ret = false;
                                break;
            case "economica":   if (aux1 >= 0 && aux2 >= 0 && aux3 >= 0 && resteconomica.getFirst() == id){
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

