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
    private int capacidad_del_comercio;
    private int Tamano_x;
    private int Tamano_y;
    private int Precio;
    
    
    /////Cradoras////////
    public Comercio(int OID){
        super(OID);
    }
    
    public Comercio(int OID, int cap, int tam_x, int tam_y, int precio){
        super(OID);
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
    
    void setTamaño(int x,int y){
        this.Tamano_x=x;
        this.Tamano_y=y;
    }
    ///////////////////////////
    
    ////Consultoras/////
    public int getCapacidad(){
        return capacidad_del_comercio;
    }
    
     int getTamanoX(){
        return this.Tamano_x;
    }
    
    int getTamanoY(){
        return this.Tamano_y;
    }
    //////////////////////////
    
}
