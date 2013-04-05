/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author ivanmartinez
 */
public class Viviendas extends Elementos {
    
    public int capacidad_maxima;
    
    public Viviendas(int OID){
        super(OID);
    }
    
    public Viviendas (int OID,int cap_max){
        super(OID);
        this.capacidad_maxima = cap_max;
    }
    
    ////ModificdoraS////
    
    public void Setcap_max(int cap_max){
        this.capacidad_maxima = cap_max;
    }
    
    ///Consultoras/////
    
    public int Getcap_max(){
        return this.capacidad_maxima;
    }
}
