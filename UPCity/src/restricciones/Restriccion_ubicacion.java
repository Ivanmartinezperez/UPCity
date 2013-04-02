/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restricciones;

import elementos.Cjt_Elementos;

/**
 *
 * @author ivanmartinez
 */
public class Restriccion_ubicacion extends Restriccion {

    public int OID1;
    public int OID2;
    public int distancia;
    
     /// CREADORA //////////
    
    public Restriccion_ubicacion(String id, String tipo, int OID1, int OID2, int distancia){
        super(id, tipo);
        this.OID1 = OID1;
        this.OID2 = OID1;
        this.distancia = distancia;
    }
    
    /// MODIFICADORES //////
    
    public void modificar_distancia(int distancia){
        this.distancia = distancia;
    }
    
   /// CONSULTORES ////////
    
    public int consultar_distancia(){
        return this.distancia;
    }
    
    public int consultar_OID1(){
        return this.OID1;
    }
    
    public int consultar_OID2(){
        return this.OID2;
    }
    
    @Override
    boolean checkRestriction(Cjt_Elementos cE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
