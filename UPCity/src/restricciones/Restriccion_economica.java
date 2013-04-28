/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restricciones;

import elementos.Cjt_Elementos;

/**
 *
 * @author rondavidsofer
 */
public class Restriccion_economica extends Restriccion {
     
   public int saldo;
   public int[] saldos;
   
   
   //CREADORA///////
   
   /**
    * Creadora vacia(necesaria para CtrlDonBarrios)
    */
   public Restriccion_economica(){
       
   }
   
   
   /**
    * Creadora de restriccion economica
    * @param id id de la restriccion
    * @param tipo tipo de restriccion
    * @param saldo_com cantidad de dinero para invertir en comercios
    * @param saldo_viv cantidad de dinero para invertir en viviendas
    * @param saldo_pub cantidad de dinero para invertir en servicios publicos
    */
   public Restriccion_economica( String id, String tipo,int saldo_com, int saldo_viv, int saldo_pub){
       super(id, tipo);
       this.saldo = saldo_com + saldo_viv + saldo_pub;
       int tam = 3;
       this.saldos = new int[tam];
       this.saldos[0] = saldo_com;
       this.saldos[1] = saldo_viv;
       this.saldos[2] = saldo_pub;
   }
   /////////////////
   
   //MODIFICADORAS///////
   
   /**
    * Modificadora de la cantidad de dinero para invertir
    * @param saldo_com cantidad de dinero para invertir en comercios
    * @param saldo_viv cantidad de dinero para invertir en viviendas
    * @param saldo_pub cantidad de dinero para invertir en servicios publicos 
    */
   public void Modificarsaldo(int saldo_com, int saldo_viv, int saldo_pub){
       this.saldo = saldo_com + saldo_viv + saldo_pub;
       this.saldos[0] = saldo_com;
       this.saldos[1] = saldo_viv;
       this.saldos[2] = saldo_pub;
   }
   
   /**
    * modificar 
    * @param id
    * @param saldo_ind 
    */
   /*
   public void Modificarsaldo_indiv(int id, int saldo_ind){
       this.saldo = this.saldo - this.saldos[id];
       this.saldos[id] = saldo_ind;
       this.saldo = this.saldo + saldo_ind;
   }
   */
   ///////////////////////
   
   //CONSULTORAS/////////
   /**
    * Consultora del total de dinero para invertir
    * @return retorna el total de dinero
    */
   public int consultar_saldo(){
       return this.saldo;
   }
   
   /**
    * Consultora de cantidad de dinero para invertir en un tipo de elementos
    * precondicion: id tiene que ser entre 0 a 2. 0 siendo comercios, 1 viviendas, y 2 servicios publicos
    * @param id id de tipo de elemento
    * @return retorna la cantidad de dinero para el tipo de elementos deseado
    */
   public int consultar_saldo_ind(int id){
       return this.saldos[id];
   }

    @Override
    boolean checkRestriction(Cjt_Elementos cE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
