
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.util.TreeMap;


/**
 *
 * @author ivanmartinez
 */
public class Cjt_Elementos extends TreeMap {
    
    //public TreeMap <String,Integer> cjt_elem ;
   
   //CREADORA/////
   void Cjt_Elementos(){
       //this.cjt_elem = new TreeMap<>();
   }
   /////////////////////
   //////METODOS PRIVADOS/////////////
   private boolean existe_elemento(String codigo){
       return this.containsKey(codigo);
        
   }
   /////////////////////////////////
   //////MODIFICADORAS//////////////////////////////
   public void añadir_elemento(String codigo,Integer cantidad ){
       this.put(codigo,cantidad);
   }
   
   public void eliminar_elemeto(String codigo){
       if(this.existe_elemento(codigo)){
           this.remove(codigo);
       }
       else {
           System.out.println("El elemento seleccionado no se haya en el conjunto");
       }
   }
   
   ////////////////////////////////////////////////
   ///////////CONSULTORAS////////////
    public Integer consultar_elemento(String codigo){
       Integer valor;
       valor = (Integer) this.get(codigo);
       return valor;
   }
   
      
}
