/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restricciones;

/**
 *
 * @author rondavidsofer
 */
public class Restriccion_economica {
     
   public int saldo;
   public int[] saldos;
   
   
   //CREADORA///////
   public Restriccion_economica( int saldo_com, int saldo_viv, int saldo_pub){
       this.saldo = saldo_com + saldo_viv + saldo_pub;
       int tam = 3;
       this.saldos = new int[tam];
       this.saldos[0] = saldo_com;
       this.saldos[1] = saldo_viv;
       this.saldos[2] = saldo_pub;
   }
   /////////////////
   
   //MODIFICADORAS///////
   public void Modificarsaldo(int saldo_com, int saldo_viv, int saldo_pub){
       this.saldo = saldo_com + saldo_viv + saldo_pub;
       this.saldos[0] = saldo_com;
       this.saldos[1] = saldo_viv;
       this.saldos[2] = saldo_pub;
   }
   
   public void Modificarsaldo_indiv(int id, int saldo_ind){
       this.saldo = this.saldo - this.saldos[id];
       this.saldos[id] = saldo_ind;
       this.saldo = this.saldo + saldo_ind;
   }
   ///////////////////////
   
   //CONSULTORAS/////////
   public int consultar_saldo(){
       return this.saldo;
   }
   
   public int consultar_saldo_ind(int id){
       return this.saldos[id];
   }
}
