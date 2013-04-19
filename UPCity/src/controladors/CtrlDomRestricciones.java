/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import restricciones.*;
/**
 *
 * @author ron
 */
public class CtrlDomRestricciones {
    public boolean CrearRestriccion(String id, String tipo, String OID1, String OID2, int aux1, int aux2, int aux3){
            
            System.out.println("Entra");
                boolean ret=true;
            
                switch(tipo){
                    case "ubicacion" : Restriccion_ubicacion u = new Restriccion_ubicacion(id, tipo, OID1, OID2, aux1);
                             break;
                    case "economica" : Restriccion_economica e = new Restriccion_economica(id, tipo, aux1, aux2, aux3);
                             break;
                    case "demografica" : Restriccion_demografica d = new Restriccion_demografica(id, tipo, OID1, aux1);
                             break;
                    default: ret = false;
                }
                
                return ret;
        
        }
    public boolean Modificar_Distancia(Restriccion r, int distancia){
        r.modificar_distancia()
    }
}

