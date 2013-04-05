
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.util.TreeMap;
import Auxiliares.Pair;

/**
 *
 * @author ivanmartinez
 */
public class Cjt_Elementos extends TreeMap {
    
   
   //CREADORA/////
   public  Cjt_Elementos(){
   }
   /////////////////////
   
   
   //////METODOS PRIVADOS/////////////
   
   /* Funcion para evitar NULLPOINTERSEXCEPTIONS*/
   private boolean existe_elemento(Integer OID){
       return this.containsKey(OID);
        
   }
   
   /////////////////////////////////
   
   
   //////MODIFICADORAS//////////////////////////////
   public void modificar_elemento(Integer OID,/*Pair <int,Elementos>*/ Integer valor ){
       this.put(OID,valor);
   }
   
   public void anadir_elementos(Integer OID,Integer cantidad){
       if(this.existe_elemento(OID)){
           Integer Nuevo_valor =(Integer) this.get(OID)+cantidad;
           if(Nuevo_valor > 0){
               this.put(OID, Nuevo_valor);
           }
           else{
               this.remove(OID);
           }
           
       }
   }
   
   public void eliminar_elementos(Integer OID,Integer cantidad){
       if(this.existe_elemento(OID)){
           Integer Nuevo_valor =(Integer) this.get(OID)-cantidad;
           if(Nuevo_valor > 0){
               this.put(OID, Nuevo_valor);
           }
           else{
               this.remove(OID);
           }
           
       }
   }
   
   ////////////////////////////////////////////////
   
   
   ///////////CONSULTORAS////////////
    public Integer consultar_elemento(Integer OID){
       Integer valor;
       valor = (Integer) this.get(OID);
       return valor;
   }
   ///////////////////////////////////
      
}
