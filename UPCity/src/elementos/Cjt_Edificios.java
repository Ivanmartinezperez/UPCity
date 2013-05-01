/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import Auxiliares.Pair;


/**
 *
 * @author Artem Cherkashin
 */
public class Cjt_Edificios extends Cjt_Elementos {
    
   
   //CREADORA/////
   public  Cjt_Edificios(){
   }
   /////////////////////
   
   
   
   public void anadir_cantidad_elementos(Integer OID,Integer cantidad){
       if(this.containsKey(OID)){
           Pair aux;
           aux = (Pair) this.get(OID);
           Integer Nuevo_valor =(Integer) aux.getFirst()+cantidad;
           aux.setFirst(Nuevo_valor);
           if(Nuevo_valor > 0){
               this.put(OID, aux);
           }
           else{
               this.remove(OID);
           }
           
       }
   }
   
   public void eliminar_cantidad_elementos(Integer OID,Integer cantidad){
       if(this.containsKey(OID)){
           Pair aux;
           aux = (Pair) this.get(OID);
           Integer Nuevo_valor =(Integer) aux.getFirst()-cantidad;
           aux.setFirst(Nuevo_valor);
           if(Nuevo_valor > 0){
               this.put(OID, aux);
           }
           else{
               this.remove(OID);
           }
           
       }
   }
}
