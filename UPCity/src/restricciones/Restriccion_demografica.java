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
    
   /**
    * Creadora de Restriccion_demografica
    * @param id id de la restriccion
    * @param tipo tipo de restriccion
    * @param OID1 id del elemento relacionado
    * @param habitantes cantidad minima de habitantes
    */  
    public Restriccion_demografica(String id, String tipo, String OID1, int habitantes){
        super(id, tipo);
        this.habitantes = habitantes;
        this.OID = OID1;
    }
   
    
   /////////////////////////
    
    /// MODIFICADORES //////
    /**
     * Modifica la cantidad minima de habitantes relacionado con el elemento
     * @param habitantes cantidad minima de habitantes para el elemento relacionado
     */
    public void modificar_habitantes(int habitantes){
        this.habitantes = habitantes;
    }
    ///////////////////////
    
    /// CONSULTORES ////////
   /**
    * Consultora de la cantidad minima de habitantes 
    * @return retorna la cantidad minima de habitantes
    */
    public int consultar_habitantes(){
        return this.habitantes;
    }
    
    /**
     * Consultora del id del elemento relacionado
     * @return retorna el id del elemento relacionado
     */
    public String consultar_OID(){
        return this.OID;
    }
   
   
   /////////////////////////

    @Override
    boolean checkRestriction(Cjt_Elementos cE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
