/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restricciones;
import elementos.*;

/**
 *
 * @author ronsofer
 */
public class Restriccion_demografica extends Restriccion {
    public int porcentaje;
    public int OID;
    
    /// CREADORA //////////
   // public Restriccion_demografica(){
    //super();
    //}
    
     
    public Restriccion_demografica(String id, String tipo, int OID, int por){
    super(id, tipo);
    this.OID = OID;
    this.porcentaje = por;
    }
   
    
   /////////////////////////
    
    /// MODIFICADORES //////
    
    public void modificar_porcentaje(int por){
        this.porcentaje = por;
    }
    ///////////////////////
    
    /// CONSULTORES ////////
    
   public int consultar_porcentaje(){
       return this.porcentaje;
   }
   
   public int consultar_OID() {
        return this.OID;
   }
   
   
   /////////////////////////

    @Override
    boolean checkRestriction(Cjt_Elementos cE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
