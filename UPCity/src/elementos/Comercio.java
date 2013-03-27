/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author ivanmartinez
 */
public class Comercio extends Elementos {
    public int capacidad_del_comercio;
    
    public Comercio(int OID, int cap){
        super(OID);
        this.capacidad_del_comercio=cap;
        
    }
    
    public void setCapacidad(int cap){
        this.capacidad_del_comercio=cap;
    }
    
    public int getCapacidad(){
        return capacidad_del_comercio;
    }
    
    
}
