/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author ivanmartinez
 */
public class Comercio extends Elemento {
    private int TBarrio;
    private int capacidad_del_comercio;
    private int Tamano_x;
    private int Tamano_y;
    private int Precio;
    
    
    /////Cradoras////////
    public Comercio(int OID){
        super(OID);
    }
    
    public Comercio(int OID, int cap, int tam_x, int tam_y, int precio, 
                    int tbarr){
        super(OID);
        TBarrio = tbarr;
        this.Tamano_x = tam_x;
        this.Tamano_y = tam_y;
        this.Precio = precio;
        this.capacidad_del_comercio=cap;
        
    }
    /////////////////////
    
    ///Modificadoras////////////
    public void setCapacidad(int cap){
        this.capacidad_del_comercio=cap;
    }
    
    public void setTamaño(int x,int y){
        this.Tamano_x=x;
        this.Tamano_y=y;
    }
    
    public void setTBarrio(int bar){
        TBarrio = bar;
    }
    ///////////////////////////
    
    ////Consultoras/////
    public int getCapacidad(){
        return capacidad_del_comercio;
    }
    
    public int getTamanoX(){
        return this.Tamano_x;
    }
    
    public int getTamanoY(){
        return this.Tamano_y;
    }
    
    public int getTBarrio(){
        return TBarrio;
    }
    
    //////////////////////////
    
}
