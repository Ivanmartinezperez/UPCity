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
    private int habitantes;
    private String OID;
    /// CREADORA //////////
   // public Restriccion_demografica(){
    //super();
    //}
    
     
    public Restriccion_demografica(String id, String tipo, String OID1, int habitantes){
        super(id, tipo);
        this.habitantes = habitantes;
        this.OID = OID1;
    }
   
    
   /////////////////////////
    
    /// MODIFICADORES //////
    
    public void modificar_habitantes(int habitantes){
        this.habitantes = habitantes;
    }
    ///////////////////////
    
    /// CONSULTORES ////////
   
    public int consultar_habitantes(){
        return this.habitantes;
    }
    
    public String consultar_OID(){
        return this.OID;
    }
   
   
   /////////////////////////

    @Override
    boolean checkRestriction(Cjt_Elementos cE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
