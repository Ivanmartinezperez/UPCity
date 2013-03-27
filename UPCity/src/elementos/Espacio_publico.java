/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author ivanmartinez
 */
public class Espacio_publico extends Elementos {
    /*Este atributo nos indica a cuanta gente puede atender el comercio*/
    public int tipo_espacio_publico;
    
    public Espacio_publico(int OID,int tipo){
        super(OID);
        this.tipo_espacio_publico=tipo;
    }
    
}
