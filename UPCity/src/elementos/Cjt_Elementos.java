
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
       return containsKey(OID);
        
   }
   
   /////////////////////////////////
   
   
   //////MODIFICADORAS//////////////////////////////
   public void insertar_elementos(Integer OID,Pair valor ){
       put(OID,valor);
   }
   
   ////////////////////////////////////////////////
   
   
   ///////////CONSULTORAS////////////
    public Pair consultar_elemento(Integer OID){
          Pair valor;
          valor = (Pair) get(OID);
          return valor;
   }
    
    /* Esta funcion retorna la raiz del arbol Y LA ELIMINA DE EL!!!*/
    public Pair primer_elemento(){
            Pair valor;
            valor = (Pair) pollFirstEntry().getValue();
            return valor;
    }
    
   ///////////////////////////////////
      
}