
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import Auxiliares.Pair;
import java.util.TreeMap;

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
   public void insertar_elementos(Integer OID,Pair valor ){
       this.put(OID,valor);
       Pair<Integer,Elemento> p =(Pair) this.get(OID);
   }
   
   public void anadir_cantidad_elementos(Integer OID,Integer cantidad){
       if(this.existe_elemento(OID)){
           Pair aux;
           aux = (Pair) this.get(OID);
           Integer Nuevo_valor =(Integer) aux.getFirst()+cantidad;
           aux.setSecond(Nuevo_valor);
           if(Nuevo_valor > 0){
               this.put(OID, aux);
           }
           else{
               this.remove(OID);
           }
           
       }
   }
   
   public void eliminar_cantidad_elementos(Integer OID,Integer cantidad){
       if(this.existe_elemento(OID)){
           Pair aux;
           aux = (Pair) this.get(OID);
           Integer Nuevo_valor =(Integer) aux.getFirst()-cantidad;
           aux.setSecond(Nuevo_valor);
           if(Nuevo_valor > 0){
               this.put(OID, aux);
           }
           else{
               this.remove(OID);
           }
           
       }
   }
   
   ////////////////////////////////////////////////
   
   
   ///////////CONSULTORAS////////////
    public Pair consultar_elemento(Integer OID){
          Pair valor;
          valor = (Pair) this.get(OID);
          return valor;
   }
    
    /* Esta funcion retorna la raiz del arbol Y LA ELIMINA DE EL!!!*/
    public Pair primer_elemento(){
            Pair valor;
            valor = (Pair) this.pollFirstEntry().getValue();
            return valor;
    }
    
   ///////////////////////////////////
      
}