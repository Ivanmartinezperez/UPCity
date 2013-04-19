/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restricciones;

import elementos.Cjt_Elementos;

/**
 *
 * @author ron
 */
public class Restriccion_ubicacion extends Restriccion {

    private String OID1;
    private String OID2;
    public int distancia;
    
     /// CREADORA //////////
    
    /**
     * Creadora de restriccion de ubicacion.
     * @param id id de la restriccion
     * @param tipo tipo de restriccion
     * @param OID1 id del primer elemento relacionado
     * @param OID2 id del segundo elemento relacionado
     * @param distancia distancia minima entre ambos elementos
     */
    public Restriccion_ubicacion(String id, String tipo, String OID1, String OID2, int distancia){
        super(id, tipo);
        this.OID1 = OID1;
        this.OID2 = OID1;
        this.distancia = distancia;
    }
    
    /// MODIFICADORES //////
    
    /**
     * Modificadora de distancia minima
     * @param distancia distancia minima nueva entre los elementos
     */
    public void modificar_distancia(int distancia){
        this.distancia = distancia;
    }
    
   /// CONSULTORES ////////
    /**
     * Consultora de distancia minima
     * @return devuelve la distancia minima
     */
    public int consultar_distancia(){
        return this.distancia;
    }
    
    /**
     * Consultora del primer elemento relacionado
     * @return devuelve el id del primer elemento relacionado
     */
    public String consultar_OID1(){
        return this.OID1;
    }
    
    /**
     * Consultora del segundo elemento relacionado
     * @return devuelve el id del segundo elemento relacionado
     */
    public String consultar_OID2(){
        return this.OID2;
    }
    
    @Override
    boolean checkRestriction(Cjt_Elementos cE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}